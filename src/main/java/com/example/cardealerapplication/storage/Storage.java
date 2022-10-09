package com.example.cardealerapplication.storage;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.salon.Salon;

import java.util.*;

public class Storage {
    private Set<Car> cars = new HashSet<>();
    private Set<Salon> salons = new HashSet<>();

    public synchronized List<Salon> findAllProfessions() {
        return new ArrayList<>(salons);
    }
}
    public Optional<Salon> findProfession(String name) {
        return salons.stream()
                .filter(salon -> salon.getName().equals(name))
                .findFirst()
                .map(CloningUtility::clone);
    }