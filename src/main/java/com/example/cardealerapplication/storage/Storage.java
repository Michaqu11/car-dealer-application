package com.example.cardealerapplication.storage;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.salon.Salon;
import com.example.cardealerapplication.serialization.CloningUtility;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Storage {
    private final Set<Car> cars = new HashSet<>();
    private final Set<Salon> salons = new HashSet<>();

    public synchronized List<Salon> findAllSalons() {
        return new ArrayList<>(salons);
    }

    public Optional<Salon> findSalon(Long id) {
        return salons.stream()
                .filter(salon -> salon.getId().equals(id))
                .findFirst()
                .map(CloningUtility::clone);
    }

    public synchronized void createSalon(Salon salon) throws IllegalArgumentException {
        salon.setId(findAllSalons().stream().mapToLong(Salon::getId).max().orElse(0) + 1);
        salons.add(salon);
    }

    public synchronized void deleteSalon(Long id) throws IllegalArgumentException {
        findSalon(id).ifPresentOrElse(
                salons::remove,
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The character with id \"%d\" does not exist", id));
                });
    }

    public synchronized List<Car> findAllCars() {
        return cars.stream().map(CloningUtility::clone).collect(Collectors.toList());
    }

    public synchronized Optional<Car> findCar(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .map(CloningUtility::clone);
    }

    public synchronized void createCar(Car car) throws IllegalArgumentException {
        car.setId(findAllCars().stream().mapToLong(Car::getId).max().orElse(0) + 1);
        cars.add(car);
    }


    public synchronized void deleteCar(Long id) throws IllegalArgumentException {
        findCar(id).ifPresentOrElse(
                cars::remove,
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The character with id \"%d\" does not exist", id));
                });
    }

}