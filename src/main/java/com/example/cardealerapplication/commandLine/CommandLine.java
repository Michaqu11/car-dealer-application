package com.example.cardealerapplication.commandLine;

import com.example.cardealerapplication.car.Car;
import com.example.cardealerapplication.car.CarService;
import com.example.cardealerapplication.salon.Salon;
import com.example.cardealerapplication.salon.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static java.lang.System.exit;


@RequiredArgsConstructor
@Component
public class CommandLine implements CommandLineRunner {

    private final CarService carService;
    private final SalonService salonService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nCurrent salons: ");
        salonService.findAll().forEach(System.out::println);

        System.out.println("\nCurrent cars: ");
        carService.findAll().forEach(System.out::println);

        while (true) {
            System.out.println("\nCommands: \n");
            System.out.println("1 - add Salon");
            System.out.println("2 - find Salon by id");
            System.out.println("3 - find all Salons");
            System.out.println("4 - delete Salon");
            System.out.println("5 - add Car");
            System.out.println("6 - find Car by id");
            System.out.println("7 - find all Cars");
            System.out.println("8 - delete Car");
            System.out.println("e - exit");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "1":
                    System.out.println("Enter salon name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter adress: ");
                    String adress = scanner.nextLine();

                    Salon salon = Salon.builder()
                            .name(name)
                            .adress(adress)
                            .build();
                    salonService.create(salon);
                    break;
                case "2":
                    System.out.println("Enter id: ");
                    System.out.println(salonService.find(Long.parseLong(scanner.nextLine())));
                    break;
                case "3":
                    salonService.findAll().forEach(System.out::println);
                    break;
                case "4":
                    System.out.println("Enter id: ");
                    salon = salonService.find(Long.parseLong(scanner.nextLine())).orElseThrow(
                            () -> {
                                throw new RuntimeException("There is no driver with that id");
                            }
                    );
                    salonService.delete(salon);
                    break;
                case "5":
                    System.out.println("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.println("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.println("Enter max speed: ");
                    double maxSpeed = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter salon id: ");
                    Long salonId = Long.parseLong(scanner.nextLine());

                     salon = salonService.find(salonId).orElseThrow(
                            () -> {
                                throw new RuntimeException("There is no salon with that id");
                            });


                    Car car = Car.builder()
                            .brand(brand)
                            .model(model)
                            .maxSpeed(maxSpeed)
                            .salon(salon)
                            .build();
                    carService.create(car);
                    break;
                case "6":
                    System.out.println("Enter id: ");
                    System.out.println(carService.find(Long.parseLong(scanner.nextLine())));
                    break;
                case "7":
                    carService.findAll().forEach(System.out::println);
                    break;
                case "8":
                    System.out.println("Enter id: ");
                    car = carService.find(Long.parseLong(scanner.nextLine())).orElseThrow(
                            () -> {
                                throw new RuntimeException("There is no car with that id");
                            }
                    );
                    carService.delete(car);
                    break;
                case "e":
                    exit(0);

            }

        }
    }
}
