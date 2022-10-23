package com.example.cardealerapplication.salon;


import com.example.cardealerapplication.salon.dto.CreateSalonRequest;
import com.example.cardealerapplication.salon.dto.GetSalonResponse;
import com.example.cardealerapplication.salon.dto.GetSalonsResponse;
import com.example.cardealerapplication.salon.dto.UpdateSalonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    public ResponseEntity<GetSalonsResponse> getSalons() {
        return ResponseEntity.ok(GetSalonsResponse.entityToDtoMapper().apply(salonService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetSalonResponse> getSalon(@PathVariable("id") long id) {
        Salon salon = salonService.find(id).orElseThrow(() -> new RuntimeException("There is not salon with that name"));
        return new ResponseEntity(GetSalonResponse.entityToDtoMapper().apply(salon), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createSalon(@RequestBody CreateSalonRequest request, UriComponentsBuilder builder) {
        Salon salon = CreateSalonRequest.dtoToEntityMapper().apply(request);
        salonService.create(salon);
        return ResponseEntity.created(builder.pathSegment( "salon", "{id}").buildAndExpand(salon.getId()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable("id") long id) {
        Optional<Salon> salon = salonService.find(id);
        if (salon.isPresent()) {
            salonService.delete(salon.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSalon(@RequestBody UpdateSalonRequest request, @PathVariable("id") long id) {
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
