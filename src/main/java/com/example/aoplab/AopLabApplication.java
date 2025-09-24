package com.example.aoplab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy   
public class AopLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopLabApplication.class, args);
    }
}
