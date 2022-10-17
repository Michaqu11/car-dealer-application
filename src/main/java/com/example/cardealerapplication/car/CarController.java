package com.example.cardealerapplication.car;

import com.example.cardealerapplication.car.CarService;
import com.example.cardealerapplication.car.dto.CreateCarRequest;
import com.example.cardealerapplication.car.dto.GetCarResponse;
import com.example.cardealerapplication.car.dto.UpdateCarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @GetMapping
    public ResponseEntity<GetCarResponse> getCar() {
        return ResponseEntity.ok(GetCarResponse.entityToDtoMapper().apply((Car) carService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetCarResponse> getCar(@PathVariable("id") long id) {
        Optional<Car> character = carService.find(id);
        return character.map(value -> ResponseEntity.ok(GetCarResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createCar(@RequestBody CreateCarRequest request, UriComponentsBuilder builder) {
        Car car = (Car) CreateCarRequest
                .dtoToEntityMapper();
        carService.create(car);
        return ResponseEntity.created(builder.pathSegment("api", "car", "{id}").buildAndExpand(car.getId()).toUri()).build();
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
