package com.example.cardealerapplication.salon.dto;


import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.car.dto.CreateCarRequest;
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
public class CreateSalonRequest {

    private String name;
    private String adress;

    public static Function<CreateSalonRequest, Salon> dtoToEntityMapper() {
        return request -> Salon.builder()
                .name(request.getName())
                .adress(request.getAdress())
                .build();
    }
}
