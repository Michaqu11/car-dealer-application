package com.example.cardealerapplication.salon.dto;


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
public class GetSalonsResponse {


    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Salon {

        private String name;
        private List<String> cars;
    }

    @Singular
    private List<Salon> salons;


    public static Function<Collection<com.example.cardealerapplication.salon.Salon>, GetSalonsResponse> entityToDtoMapper() {
        return salons -> {
            GetSalonsResponseBuilder response = GetSalonsResponse.builder();
            salons.stream()
                    .map(salon -> Salon.builder()
                            .name(salon.getName())
                            .cars(salon.getCars().stream().map(car -> car.getBrand() + " " + car.getModel()).toList())
                            .build())
                    .forEach(response::salon);
            return response.build();
        };
    }
}