package com.example.cardealerapplication.configuration;

import com.example.cardealerapplication.salon.Salon;
import com.example.cardealerapplication.salon.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializedData {

    private final SalonService salonService;

    @Autowired
    public InitializedData(SalonService salonService) {
        this.salonService = salonService;
    }

    @PostConstruct
    private synchronized void init() {
        Salon topCars = Salon.builder()
                .name("Top Cars")
                .saveName("Top Cars")
                .address("Grunwaldzka 123 80-321 Gdańsk")
                .build();


        Salon bellaCars = Salon.builder()
                .name("Bella Cars")
                .saveName("Bella Cars")
                .address("Świętokrzyska 5 47-231 Nidzica")
                .build();


        salonService.createLocal(topCars);
        salonService.createLocal(bellaCars);

    }

}
