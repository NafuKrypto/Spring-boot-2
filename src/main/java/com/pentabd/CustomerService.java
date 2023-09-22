package com.pentabd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer updateCustomer(Integer id, Customer updateCustomer){
        Customer existingCustomer=customerRepository.findById(id).orElse(null);
        if(existingCustomer!=null){
            existingCustomer.setName(updateCustomer.getName());
            existingCustomer.setEmail(updateCustomer.getEmail());
            existingCustomer.setAge(updateCustomer.getAge());

            return customerRepository.save(existingCustomer);
        }else {
            return null;
        }

    }
}
