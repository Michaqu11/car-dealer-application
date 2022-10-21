package com.example.cardealerapplication.event;


import com.example.cardealerapplication.salon.Salon;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateSalonRequest {

    private String name;
    public static Function<Salon, CreateSalonRequest> entityToDtoMapper() {
        return entity -> CreateSalonRequest.builder()
                .name(entity.getName())
                .build();
    }

}
