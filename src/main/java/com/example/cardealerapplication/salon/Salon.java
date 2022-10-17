package com.example.cardealerapplication.salon;


import com.example.cardealerapplication.car.Car;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "salons")
public class Salon implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String address;


    @OneToMany(mappedBy = "salon")
    private Set<Car> cars;


}
