package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.models")  
public class Tutoria2Application {
    public static void main(String[] args) {
        SpringApplication.run(Tutoria2Application.class, args);
    }
}