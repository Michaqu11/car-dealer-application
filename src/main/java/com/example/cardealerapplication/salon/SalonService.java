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
        return repository.find(id);
    }

    public List<Salon> findAll() {
        return repository.findAll();
    }

    public void create(Salon salon) {
        repository.create(salon);
    }

    public void delete(Salon salon) {
        repository.delete(repository.find(salon.getId()).orElseThrow());
    }

    public void update(Salon salon) {
        repository.update(salon);
    }
}
