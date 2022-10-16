package com.example.cardealerapplication.salon;

import com.example.cardealerapplication.repository.Repo;
import com.example.cardealerapplication.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class SalonRepository implements Repo<Salon, Long> {

    private final Storage store;


    @Override
    public Optional<Salon> find(Long id) {
        return store.findSalon(id);
    }

    @Override
    public List<Salon> findAll() {
        return store.findAllSalons();
    }

    @Override
    public void create(Salon salon) {
        store.createSalon(salon);
    }

    @Override
    public void delete(Salon salon) {
        store.deleteSalon(salon.getId());
    }

}
