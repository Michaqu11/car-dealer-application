package com.example.cardealerapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarDealerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarDealerApplication.class, args);
    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("slons", r -> r.host("localhost:8080")
//                        .and()
//                        .path("salon/{name}", "/salon")
//                        .uri("http://localhost:8081"))
//                .route("car", r -> r.host("localhost:8080")
//                        .and()
//                        .path("/car", "/car/**", "/salon/{name}/car", "/salon/{name}/car/**")
//                        .uri("http://localhost:8082"))
//                .build();
//    }
//
}
