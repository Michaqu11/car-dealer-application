package com.example.cardealerapplication.configuration;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.car.CarService;
import com.example.cardealerapplication.salon.Salon;
import com.example.cardealerapplication.salon.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class InitializedData {


    private final CarService carService;
    private final SalonService salonService;

    @Autowired
    public InitializedData(CarService carService, SalonService salonService) {
        this.carService = carService;
        this.salonService = salonService;
    }



    @PostConstruct
    private synchronized void init() {
        Salon topCars = Salon.builder()
                .name("Top Cars")
                .address("Grunwaldzka 123 80-321 Gdańsk")
                .build();


        Salon bellaCars = Salon.builder()
                .name("Bella Cars")
                .address("Świętokrzyska 5 47-231 Nidzica")
                .build();


        salonService.create(topCars);
        salonService.create(bellaCars);

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


//        carService.create(mercedes);
//        carService.create(audi);
//        carService.create(scoda);
//        carService.create(mercedes1);
//        carService.create(bmw);






    }

}
