package com.example.cardealerapplication.salon;


import com.example.cardealerapplication.car.Car;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Data
@SuperBuilder
public class Salon  implements Serializable {
    private Long id;
    private String name;
    private String adress;
}
