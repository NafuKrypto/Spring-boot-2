package com.pentabd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages = "com.pentabd")
//@EnableAutoConfiguration
//@Configuration
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        System.out.println("Hello");
    }


    @GetMapping("/greet")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/greeting")
    public Greeting greeting(){
        return  new Greeting("My name is khane hello");
    }

    record Greeting (String greets){
    //class
    }
}
