package com.example.cardealerapplication.car.dto;


import com.example.cardealerapplication.car.Car;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.function.Function;
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateCarRequest {

    private String brand;
    private String model;
    private double maxSpeed;
    private String salonName;

    public static Function<CreateCarRequest, Car> dtoToEntityMapper() {
        return request -> Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .maxSpeed(request.getMaxSpeed())
                .build();
    }


}
