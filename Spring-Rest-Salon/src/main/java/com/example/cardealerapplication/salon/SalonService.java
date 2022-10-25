package com.example.cardealerapplication.salon;

import com.example.cardealerapplication.event.SalonEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {
    private SalonRepository repository;
    private SalonEventRepository eventRepository;

    @Autowired
    public SalonService(SalonRepository repository, SalonEventRepository eventRepository){
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public Optional<Salon> find(Long id) {
        return repository.findById(id);
    }

    public List<Salon> findAll() {
        return repository.findAll();
    }

    public Salon create(Salon salon) {
        eventRepository.create(salon);
        return repository.save(salon);
    }

    public void delete(Salon salon) {
        repository.deleteById(salon.getId());
        eventRepository.delete(salon);
    }

    public void update(Salon salon, String newName, String newAddress) {
        eventRepository.update(salon.getSaveName(), newName);
        salon.setName(newName);
        salon.setAddress(newAddress);
        repository.save(salon);
    }
}
