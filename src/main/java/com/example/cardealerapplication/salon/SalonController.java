package com.example.cardealerapplication.salon;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.car.dto.CreateCarRequest;
import com.example.cardealerapplication.car.dto.GetCarResponse;
import com.example.cardealerapplication.car.dto.UpdateCarRequest;
import com.example.cardealerapplication.salon.dto.CreateSalonRequest;
import com.example.cardealerapplication.salon.dto.GetSalonResponse;
import com.example.cardealerapplication.salon.dto.GetSalonsResponse;
import com.example.cardealerapplication.salon.dto.UpdateSalonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/salon")
public class SalonController {

    private SalonService salonService;

    @Autowired
    public SalonController(SalonService salonService){
        this.salonService = salonService;
    }

    @GetMapping
    public ResponseEntity<GetSalonsResponse> getSalons() {
        return ResponseEntity.ok(GetSalonsResponse.entityToDtoMapper().apply(salonService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetSalonResponse> getSalon(@PathVariable("id") long id) {
        Optional<Salon> salon = salonService.find(id);
        return salon.map(value -> ResponseEntity.ok(GetSalonResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createSalon(@RequestBody CreateSalonRequest request, UriComponentsBuilder builder) {
        Salon salon = (Salon) CreateSalonRequest.dtoToEntityMapper();
        salonService.create(salon);
        return ResponseEntity.created(builder.pathSegment( "salon", "{id}").buildAndExpand(salon.getId()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") long id) {
        Optional<Salon> salon = salonService.find(id);
        if (salon.isPresent()) {
            salonService.delete(salon.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCar(@RequestBody UpdateSalonRequest request, @PathVariable("id") long id) {
        Optional<Salon> salon = salonService.find(id);
        if (salon.isPresent()) {
            UpdateSalonRequest.dtoToEntityUpdater().apply(salon.get(), request);
            salonService.update(salon.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
