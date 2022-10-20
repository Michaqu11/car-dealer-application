package com.example.cardealerapplication.salon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SalonService {
    private final SalonRepository repository;


    public Optional<Salon> find(Long id) {
        return repository.findById(id);
    }

    public List<Salon> findAll() {
        return repository.findAll();
    }

    public Salon create(Salon salon) {
        return repository.save(salon);
    }

    public void delete(Salon salon) {
        repository.deleteById(salon.getId());
    }

    public void update(Salon salon) {
        repository.save(salon);
    }
}
