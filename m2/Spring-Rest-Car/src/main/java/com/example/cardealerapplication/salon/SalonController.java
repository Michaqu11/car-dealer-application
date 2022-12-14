package com.example.cardealerapplication.salon;


import com.example.cardealerapplication.salon.dto.CreateSalonRequest;
import com.example.cardealerapplication.salon.dto.GetSalonResponse;
import com.example.cardealerapplication.salon.dto.GetSalonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/salon")
public class SalonController {

    private final SalonService salonService;

    @Autowired
    public SalonController(SalonService salonService){
        this.salonService = salonService;
    }

    @PostMapping
    public ResponseEntity<Void> createSalon(@RequestBody CreateSalonRequest request, UriComponentsBuilder builder) {
        Salon salon = CreateSalonRequest.dtoToEntityMapper().apply(request);
        salon.setNewName(salon.getName());
        salonService.create(salon);
        return ResponseEntity.created(builder.pathSegment( "salon", "{id}").buildAndExpand(salon.getName()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable("id") String name) {
        Optional<Salon> salon = salonService.find(name);
        if (salon.isPresent()) {
            salonService.delete(salon.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("salons")
    public ResponseEntity<GetSalonsResponse> getSalons() {
        return ResponseEntity.ok(GetSalonsResponse.entityToDtoMapper().apply(salonService.findAll()));
    }

    @GetMapping("cars/{id}")
    public ResponseEntity<GetSalonResponse> getSalonWtihCars(@PathVariable("id") String name) {
        Optional<Salon> salon = salonService.find(name);
        return salon.map(value -> ResponseEntity.ok(GetSalonResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/update/{name}")
    public ResponseEntity<Void> updateSalon(@RequestBody String newName, @PathVariable("name") String name) {
        Optional<Salon> salon = salonService.find(name);
        if (salon.isPresent()) {
            salonService.update(salon.get(), newName);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
