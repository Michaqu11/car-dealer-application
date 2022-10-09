package com.example.cardealerapplication.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return repository.find(id);
    }
    public void create(Car car) {
        repository.create(car);
    }
//    public void update(Car car) {
//        repository.update(car);
//    }
    public void delete(Car car) {
        repository.delete(repository.find(car.getId()).orElseThrow());
    }
}
