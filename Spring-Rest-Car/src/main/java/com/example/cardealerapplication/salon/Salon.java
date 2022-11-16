package com.example.cardealerapplication.salon;


import com.example.cardealerapplication.car.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "salons")
public class Salon implements Serializable {
    @Id
    private String name;
    @Column(name = "new_name")
    private String newName;

    @JsonIgnore
    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Car> cars =  new HashSet<>();


}
