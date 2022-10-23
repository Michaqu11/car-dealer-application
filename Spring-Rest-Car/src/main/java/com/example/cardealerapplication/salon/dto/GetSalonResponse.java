package com.example.cardealerapplication.salon.dto;

import com.example.cardealerapplication.salon.Salon;
import lombok.*;

import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetSalonResponse {
    private List<String> cars;


    public static Function<Salon, GetSalonResponse> entityToDtoMapper() {
        return salon -> GetSalonResponse.builder()
                .cars(salon.getCars().stream().map(car -> car.getBrand() + " " + car.getModel()).toList())
                .build();
    }
}
