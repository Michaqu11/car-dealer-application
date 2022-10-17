package com.example.cardealerapplication.car.dto;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.salon.Salon;
import lombok.*;

import java.util.function.BiFunction;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateCarRequest {

    private String brand;
    private String model;
    private double maxSpeed;
    private Salon salon;

    public static BiFunction<Car, UpdateCarRequest, Car> dtoToEntityUpdater() {
        return (car, request) -> {
            car.setBrand(request.getBrand());
            car.setModel(request.getModel());
            car.setMaxSpeed(request.getMaxSpeed());
            car.setSalon(request.getSalon());
            return car;
        };
    }
}
