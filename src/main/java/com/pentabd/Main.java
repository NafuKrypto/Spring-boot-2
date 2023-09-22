package com.pentabd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = "com.pentabd")
//@EnableAutoConfiguration
//@Configuration
@RestController
@RequestMapping("api/v1/customers")
public class Main {
    private  final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public Main(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        System.out.println("Hello");
    }
    @GetMapping()
public List<Customer> getCustomer(){
        return customerRepository.findAll();
}

record NewCustomerRequest(String name,
                          String email,
                          Integer age){

}
@PostMapping
public void addCustomer(@RequestBody  NewCustomerRequest request){
Customer customer=new Customer();
customer.setName(request.name());
customer.setEmail(request.email());
customer.setAge(request.age());
customerRepository.save(customer);
}


@DeleteMapping("{customerId}")
public void deleteCustomer(@PathVariable  ("customerId") Integer id){
        customerRepository.deleteById(id);
}
//    @GetMapping("/greet")
//    public String greet(){
//        return "Hello World";
//    }
//
//    @GetMapping("/greeting")
//    public Greeting greeting(){
//        return  new Greeting("My name is khane hello");
//    }
//
//    @GetMapping("/greetingTwo")
//    public GreetResponse greetingTwo(){
//        return  new GreetResponse("My name is nafisa hello");
//    }
//
//    @GetMapping("/greetingThree")
//    public GreetAnotherResponse greetingThree(){
//        GreetAnotherResponse response=new GreetAnotherResponse("Hi.I am Nafisa",
//                List.of("Java","Python","JavaScript"),
//                new Person("Alex",22,4444.45));
//        return response;
//    }
//
//    record Greeting (String greets){
//    //class
//    }
//
//    record Person(String name,int age,double savings){
//
//    }
//    record GreetAnotherResponse(
//            String greet,
//            List<String> favProgLang,
//            Person person
//    ){}
//
//    class GreetResponse{
//        private final String greet;
//        GreetResponse(String greet){
//
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }
@PutMapping("{customerId}")
    public  ResponseEntity<Customer> updateCustomer(@PathVariable("customerId")Integer id,@RequestBody Customer request){
      Customer updatedCustomer=customerService.updateCustomer(id,request);
    if (updatedCustomer != null) {
        return ResponseEntity.ok(updatedCustomer);
    } else {
        return ResponseEntity.notFound().build();
    }

}
}
