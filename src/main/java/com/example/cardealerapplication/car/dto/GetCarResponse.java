package com.example.cardealerapplication.car.dto;


import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.salon.Salon;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCarResponse {

    private Long id;
    private String brand;
    private String model;
    private double maxSpeed;
    private Salon salon;

    public static Function<Car, GetCarResponse> entityToDtoMapper() {
        return car -> GetCarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .maxSpeed(car.getMaxSpeed())
                .salon(car.getSalon())
                .build();
    }
}