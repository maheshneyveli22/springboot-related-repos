package com.example.hibernateevents;

import com.example.hibernateevents.model.Product;
import com.example.hibernateevents.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateEventsApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository productRepository) {
        return (args) -> {
            System.out.println("\n--- Saving a newww product (this should trigger PostInsertEventListener) ---");
            Product product1 = new Product("Laptop", 1200.00);
            productRepository.save(product1); // Listener triggered here
            System.out.println("Product saved: " + product1);

            System.out.println("\n--- Saving another product ---");
            Product product2 = new Product("Mouse", 25.50);
            productRepository.save(product2); // Listener triggered here
            System.out.println("Product saved: " + product2);

            System.out.println("\n--- Fetching all products ---");
            productRepository.findAll().forEach(System.out::println);
        };
    }
}