package com.example.cardealerapplication.event;


import com.example.cardealerapplication.salon.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class SalonEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public SalonEventRepository(@Value("${cardealer.car.url}") String baseUrl) {
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(Salon salon) {
        restTemplate.delete("/salon/{name}", salon.getSaveName());
    }

    public void create(Salon salon) {
        restTemplate.postForLocation("/salon", CreateSalonRequest.entityToDtoMapper().apply(salon));
    }

    public void update(String name, String newName) {
        restTemplate.postForLocation("/salon/update/" + name, newName);
    }

}
