package com.example.cardealerapplication.car;

import com.example.cardealerapplication.salon.Salon;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private double maxSpeed;

    @ManyToOne
    @JoinColumn(name = "salon_name",  nullable = false, referencedColumnName = "name")
    private Salon salon;
}
