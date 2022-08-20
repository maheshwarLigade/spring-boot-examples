package com.techwasti.logdemo.loggingdemo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
   
    
    List<Customer> getAllCust(){
        return List.of(new Customer(1, "Ram","India"),
        new Customer(2, "Richard","India"),
        new Customer(3, "Suresh","India"),
        new Customer(4, "Mahesh","India"),
        new Customer(5, "Ganesh","India"));

    }
}
