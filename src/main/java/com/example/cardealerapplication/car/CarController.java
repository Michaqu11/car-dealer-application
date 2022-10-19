package com.example.cardealerapplication.car;

import com.example.cardealerapplication.car.dto.CreateCarRequest;
import com.example.cardealerapplication.car.dto.GetCarResponse;
import com.example.cardealerapplication.car.dto.GetCarsResponse;
import com.example.cardealerapplication.car.dto.UpdateCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
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
        Car car = CreateCarRequest.dtoToEntityMapper().apply(request);

        carService.create(car, request.getSalonID());
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

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCar(@RequestBody UpdateCarRequest request, @PathVariable("id") long id) {
        Car car = carService.find(id).orElseThrow(
                () -> new RuntimeException("There is no car with that id!")
        );
        car = UpdateCarRequest.dtoToEntityUpdater().apply(car, request);

        carService.update(car);
        return ResponseEntity.accepted().build();
    }
}
