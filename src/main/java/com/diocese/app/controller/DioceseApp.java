package com.diocese.app.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.diocese.app.model.Greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class DioceseApp {    
    private static final String template ="Hello, %s";
    private final AtomicLong counter= new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    public static void main(String[] args){
        SpringApplication.run(DioceseApp.class, args); 
    }

}