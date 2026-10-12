package com.sooraj.learning.ordertrackerspringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderTrackerSpringProjectApplication {

    public static void main(String[] args) {
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(OrderTrackerSpringProjectApplication.class, args);
    }

//    @Bean
//    CommandLineRunner seed(CategoryRepository repo) {
//        return args -> repo.save(new Category("Electronics"));
//    }
}
