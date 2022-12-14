package com.example.cardealerapplication.salon.dto;


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
public class CreateSalonRequest {

    private String name;

    public static Function<CreateSalonRequest, Salon> dtoToEntityMapper() {
        return request -> Salon.builder()
                .name(request.getName())
                .build();
    }
}
