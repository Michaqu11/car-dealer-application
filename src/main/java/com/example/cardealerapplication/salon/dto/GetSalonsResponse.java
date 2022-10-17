package com.example.cardealerapplication.salon.dto;


import com.example.cardealerapplication.car.Car;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
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

        private Long id;
        private String name;
        private String address;
        private Set<Car> cars;
    }

    @Singular
    private List<Salon> salons;


    public static Function<Collection<com.example.cardealerapplication.salon.Salon>, GetSalonsResponse> entityToDtoMapper() {
        return salons -> {
           GetSalonsResponseBuilder response = GetSalonsResponse.builder();
            salons.stream()
                    .map(salon -> Salon.builder()
                            .id(salon.getId())
                            .name(salon.getName())
                            .address(salon.getAddress())
                            .cars(salon.getCars())
                            .build())
                    .forEach(response::salon);
            return response.build();
        };
    }
}
