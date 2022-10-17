package com.example.cardealerapplication.salon.dto;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.salon.Salon;
import lombok.*;

import java.util.Set;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSalonResponse {

    private Long id;
    private String name;
    private String adress;
    private Set<Car> cars;

    public static Function<Salon, GetSalonResponse> entityToDtoMapper() {
        return salon -> GetSalonResponse.builder()
                .id(salon.getId())
                .name(salon.getName())
                .adress(salon.getAdress())
                .cars(salon.getCars())
                .build();
    }
}
