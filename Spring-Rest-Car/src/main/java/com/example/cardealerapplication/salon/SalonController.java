package com.example.cardealerapplication.salon;


import com.example.cardealerapplication.salon.dto.CreateSalonRequest;
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

}