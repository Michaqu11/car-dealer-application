package com.example.cardealerapplication.car;

import com.example.cardealerapplication.repository.Repo;
import com.example.cardealerapplication.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


    Optional<Car> find(Long id);



     List<Car> findAll();


     void create(Car car);


     void delete(Car car);

    void update(Car car);

}
