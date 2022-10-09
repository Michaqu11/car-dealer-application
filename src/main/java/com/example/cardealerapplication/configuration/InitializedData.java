package com.example.cardealerapplication.configuration;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.car.CarService;
import com.example.cardealerapplication.salon.Salon;
import com.example.cardealerapplication.salon.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class InitializedData {

    private final CarService carService;
    private final SalonService salonService;


    @PostConstruct
    private synchronized void init() {
        Salon topCars = Salon.builder()
                .name("Top Cars")
                .adress("Grunwaldzka 123 80-321 Gdańsk")
                .build();

        Car mercedes = Car.builder()
                .brand("Mercedes")
                .model("C-class")
                .maxSpeed(245)
                .salon(topCars)
                .build();

        Car audi = Car.builder()
                .brand("Audi")
                .model("A6")
                .maxSpeed(220)
                .salon(topCars)
                .build();

        Car scoda = Car.builder()
                .brand("Scoda")
                .model("super-b")
                .maxSpeed(210)
                .salon(topCars)
                .build();


        Salon bellaCars = Salon.builder()
                .name("Bella Cars")
                .adress("Świętokrzyska 5 47-231 Nidzica")
                .build();

        Car mercedes1 = Car.builder()
                .brand("Mercedes")
                .model("E-class")
                .maxSpeed(250)
                .salon(bellaCars)
                .build();

        Car bmw = Car.builder()
                .brand("Bmw")
                .model("M3")
                .maxSpeed(280)
                .salon(bellaCars)
                .build();

        salonService.create(topCars);
        salonService.create(bellaCars);

        carService.create(mercedes);
        carService.create(audi);
        carService.create(scoda);
        carService.create(mercedes1);
        carService.create(bmw);






    }

}
