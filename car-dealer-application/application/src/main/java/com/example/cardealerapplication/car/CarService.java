package com.example.cardealerapplication.car;

import com.example.cardealerapplication.salon.Salon;
import com.example.cardealerapplication.salon.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CarService {

    private final SalonService salonService;
    private final CarRepository repository;

    public List<Car> findAll() {
        return repository.findAll();
    }

    public Optional<Car> find(Long id) {
        return repository.findById(id);
    }
    public Car create(Car car, Long salonId) {
        Salon salon = salonService.find(salonId).orElseThrow(
                () -> new RuntimeException("There is no salon with that ID")
        );
        car.setSalon(salon);
        return repository.save(car);
    }

    public void update(Car car) {
        repository.save(car);
    }

    public void delete(Car car) {
        repository.deleteById(car.getId());
    }
}
