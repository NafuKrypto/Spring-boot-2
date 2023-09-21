package com.pentabd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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

    @GetMapping("/greetingTwo")
    public GreetResponse greetingTwo(){
        return  new GreetResponse("My name is nafisa hello");
    }

    @GetMapping("/greetingThree")
    public GreetAnotherResponse greetingThree(){
        GreetAnotherResponse response=new GreetAnotherResponse("Hi.I am Nafisa",
                List.of("Java","Python","JavaScript"),
                new Person("Alex",22,4444.45));
        return response;
    }

    record Greeting (String greets){
    //class
    }

    record Person(String name,int age,double savings){

    }
    record GreetAnotherResponse(
            String greet,
            List<String> favProgLang,
            Person person
    ){}

    class GreetResponse{
        private final String greet;
        GreetResponse(String greet){

            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }

        @Override
        public String toString() {
            return "GreetResponse{" +
                    "greet='" + greet + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(greet, that.greet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(greet);
        }
    }

}
