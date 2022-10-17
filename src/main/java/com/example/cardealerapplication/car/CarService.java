package com.example.cardealerapplication.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository repository;

    public List<Car> findAll() {
        return repository.findAll();
    }

    public Optional<Car> find(Long id) {
        return repository.findById(id);
    }
    public Car create(Car car) {
        return repository.save(car);
    }

    public void update(Car car) {
        repository.save(car);
    }

    public void delete(Car car) {
        repository.deleteById(car.getId());
    }
}
