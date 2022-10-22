package com.example.cardealerapplication.car.dto;

import com.example.cardealerapplication.car.Car;
import lombok.*;

import java.util.function.BiFunction;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class UpdateCarRequest {

    private String brand;
    private String model;
    private double maxSpeed;

    public static BiFunction<Car, UpdateCarRequest, Car> dtoToEntityUpdater() {
        return (car, request) -> {
            car.setBrand(request.getBrand());
            car.setModel(request.getModel());
            car.setMaxSpeed(request.getMaxSpeed());
            return car;
        };
    }
}
