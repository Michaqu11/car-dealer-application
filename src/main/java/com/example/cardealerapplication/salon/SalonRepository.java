package com.example.cardealerapplication.salon;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalonRepository extends JpaRepository<Salon, String> {
}
