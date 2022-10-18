package com.example.cardealerapplication.car;

import com.example.cardealerapplication.car.CarService;
import com.example.cardealerapplication.car.dto.CreateCarRequest;
import com.example.cardealerapplication.car.dto.GetCarResponse;
import com.example.cardealerapplication.car.dto.GetCarsResponse;
import com.example.cardealerapplication.car.dto.UpdateCarRequest;
import com.example.cardealerapplication.salon.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;
    private SalonService salonService;

    @Autowired
    public CarController(CarService carService, SalonService salonService) {
        this.carService = carService;
        this.salonService = salonService;
    }

    @GetMapping
    public ResponseEntity<GetCarsResponse> getCars() {
        return ResponseEntity.ok(GetCarsResponse.entityToDtoMapper().apply(carService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetCarResponse> getCar(@PathVariable("id") long id) {
        Optional<Car> car = carService.find(id);
        return car.map(value -> ResponseEntity.ok(GetCarResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createCar(@RequestBody CreateCarRequest request, UriComponentsBuilder builder) {
        Car car = CreateCarRequest.dtoToEntityMapper(id -> salonService.find(id).orElseThrow()).apply(request);
        car = carService.create(car);
        car.setSalon(car.getSalon());
        return ResponseEntity.created(builder.pathSegment( "car").buildAndExpand(car.getId()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") long id) {
        Optional<Car> car = carService.find(id);
        if (car.isPresent()) {
            carService.delete(car.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCar(@RequestBody UpdateCarRequest request, @PathVariable("id") long id) {
        Optional<Car> car = carService.find(id);
        if (car.isPresent()) {
            UpdateCarRequest.dtoToEntityUpdater().apply(car.get(), request);
            carService.update(car.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
