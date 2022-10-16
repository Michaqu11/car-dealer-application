package com.example.cardealerapplication.car;

import com.example.cardealerapplication.repository.Repo;
import com.example.cardealerapplication.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements Repo<Car, Long> {
    private final Storage store;

    @Override
    public Optional<Car> find(Long id) {
        return store.findCar(id);
    }

    @Override
    public List<Car> findAll() {
        return store.findAllCars();
    }

    @Override
    public void create(Car car) {
        store.createCar(car);
    }

    @Override
    public void delete(Car car) {
        store.deleteCar(car.getId());
    }


}
