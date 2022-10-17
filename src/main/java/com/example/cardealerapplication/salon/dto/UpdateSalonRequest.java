package com.example.cardealerapplication.salon.dto;


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
public class UpdateSalonRequest {
    private String name;
    private String address;

    public static BiFunction<Salon, UpdateSalonRequest, Salon> dtoToEntityUpdater() {
        return (salon, request) -> {
            salon.setName(request.getName());
            salon.setAddress(request.getAddress());
            return salon;
        };
    }

}
