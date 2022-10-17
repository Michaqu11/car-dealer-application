package com.example.cardealerapplication.salon;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {




    Optional<Salon> find(Long id);

    List<Salon> findAll();

    void create(Salon salon);

    void delete(Salon salon);

    void update(Salon salon);
}
