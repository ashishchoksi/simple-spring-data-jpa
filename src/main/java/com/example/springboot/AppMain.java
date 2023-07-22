package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(AppMain.class, args);
    }
}