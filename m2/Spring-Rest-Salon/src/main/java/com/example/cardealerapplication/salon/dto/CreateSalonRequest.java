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

    private Long id;
    private String name;
    private String saveName;
    private String address;


    public static Function<CreateSalonRequest, Salon> dtoToEntityMapper() {
        return request -> Salon.builder()
                .id(request.getId())
                .name(request.getName())
                .saveName(request.getName())
                .address(request.getAddress())
                .build();
    }
}
