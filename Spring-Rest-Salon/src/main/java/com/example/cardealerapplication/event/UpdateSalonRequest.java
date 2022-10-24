package com.example.cardealerapplication.event;


import com.example.cardealerapplication.salon.Salon;
import com.sun.source.tree.Tree;
import lombok.*;

import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateSalonRequest {
    private String oldName;
    private String name;
    private String address;

    public static BiFunction<Salon, UpdateSalonRequest, Salon> entityToDtoMapper() {
        return (salon, request) -> {
            salon.setName(request.getName());
            salon.setAddress(request.getAddress());
            return salon;
        };
    }

}
