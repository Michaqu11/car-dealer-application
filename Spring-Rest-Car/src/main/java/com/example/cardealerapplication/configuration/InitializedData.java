package com.example.cardealerapplication.configuration;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.car.CarService;
import com.example.cardealerapplication.salon.Salon;
import com.example.cardealerapplication.salon.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
                .build();


        Salon bellaCars = Salon.builder()
                .name("Bella Cars")
                .build();

        salonService.create(topCars);
        salonService.create(bellaCars);

        Car mercedes = Car.builder()
                .brand("Mercedes")
                .model("C-class")
                .maxSpeed(245)
                .build();

        Car audi = Car.builder()
                .brand("Audi")
                .model("A6")
                .maxSpeed(220)
                .build();

        Car scoda = Car.builder()
                .brand("Scoda")
                .model("super-b")
                .maxSpeed(210)
                .build();


        Car mercedes1 = Car.builder()
                .brand("Mercedes")
                .model("E-class")
                .maxSpeed(250)
                .build();

        Car bmw = Car.builder()
                .brand("Bmw")
                .model("M3")
                .maxSpeed(280)
                .build();


        carService.create(mercedes, topCars.getName());
        carService.create(audi,  topCars.getName());
        carService.create(scoda, topCars.getName());
        carService.create(mercedes1, bellaCars.getName());
        carService.create(bmw, bellaCars.getName());






    }

}
