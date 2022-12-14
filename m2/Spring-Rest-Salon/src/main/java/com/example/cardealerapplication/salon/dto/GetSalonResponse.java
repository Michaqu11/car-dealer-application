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
public class GetSalonResponse {
    private Long id;
    private String name;
    private String saveName;
    private String address;


    public static Function<Salon, GetSalonResponse> entityToDtoMapper() {
        return salon -> GetSalonResponse.builder()
                .id(salon.getId())
                .name(salon.getName())
                .saveName(salon.getSaveName())
                .address(salon.getAddress())
                .build();
    }

}
