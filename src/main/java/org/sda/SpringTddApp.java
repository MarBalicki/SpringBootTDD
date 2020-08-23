package org.sda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTddApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringTddApp.class, args);
        System.out.println("Działam!");

    }
}
