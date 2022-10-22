package com.example.cardealerapplication.salon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SalonService {
    private final SalonRepository repository;

    public Optional<Salon> find(String name) {
        return repository.findById(name);
    }

    public Salon create(Salon salon) {
        return repository.save(salon);
    }

    public void delete(Salon salon) {
        repository.delete(salon);
    }

}
