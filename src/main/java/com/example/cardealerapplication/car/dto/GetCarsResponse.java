package com.example.cardealerapplication.car.dto;


import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.salon.Salon;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCarsResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Car {

        private Long id;
        private String brand;
        private String model;
        private double maxSpeed;
    }

    @Singular
    private List<Car> cars;

    public static Function<Collection<com.example.cardealerapplication.car.Car>, GetCarsResponse> entityToDtoMapper() {
        return cars -> {
            GetCarsResponseBuilder response = GetCarsResponse.builder();
            cars.stream()
                    .map(car -> Car.builder()
                            .id(car.getId())
                            .brand(car.getBrand())
                            .model(car.getModel())
                            .maxSpeed(car.getMaxSpeed())
                            .build())
                    .forEach(response::car);
            return response.build();
        };
    }
}
