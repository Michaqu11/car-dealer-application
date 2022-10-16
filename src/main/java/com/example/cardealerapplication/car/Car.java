package com.example.cardealerapplication.car;

import com.example.cardealerapplication.salon.Salon;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class Car implements Serializable {
    private Long id;
    private String brand;
    private String model;
    private double maxSpeed;
    private Salon salon;
}
