package com.example.cardealerapplication.car.dto;


import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.salon.Salon;
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
    private Long salonID;

    public static Function<CreateCarRequest, Car> dtoToEntityMapper(
            Function<Long, Salon> salonFunction
    ) {
        return request -> Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .maxSpeed(request.getMaxSpeed())
                .salon(salonFunction.apply(request.getSalonID()))
                .build();
    }


}