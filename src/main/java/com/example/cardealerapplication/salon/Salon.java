package com.example.cardealerapplication.salon;


import com.example.cardealerapplication.car.Car;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Salon  implements Serializable {
    private Long id;
    private String name;
    private String adress;


}
