package com.techwasti.h2paginationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer= Customer
                .builder()
                .name(customerDTO.getName())
                .mobileno(customerDTO.getMobileno())
                .createdDate(new Date())
                .createdBy(customerDTO.getCreatedBy())
                .userId(customerDTO.getUserId())
                .build();
        customerRepository.save(customer);
    }

    public List<CustomerDTO> getAllCustomers(Pageable paging){
        
        Iterable<Customer> customers= 
                customerRepository.findAll(paging);
        List<CustomerDTO> customersDTO = new ArrayList<>();

        customers.forEach( customer -> {
            customersDTO.add(CustomerDTO
                    .builder()
                    .id(customer.getId())
                    .userId(customer.getUserId())
                    .name(customer.getName())
                    .mobileno(customer.getMobileno())
                    .createdBy(customer.getCreatedBy())
                    .createdDate(customer.getCreatedDate())
                    .build());
        });

        return customersDTO;
    }

    
public List<CustomerDTO> getCustomersByUserId(
            String userId, 
            Pageable page) {
       Optional<List<Customer>> customers =  
      customerRepository.findAllByUserId(userId, page);
      
      if (customers.isPresent()) {
          return customers.get()
                   .stream()
                   .map( customer ->  CustomerDTO.builder()
                       .id(customer.getId())
                       .name(customer.getName())
                       .mobileno(customer.getMobileno())
                       .userId(customer.getUserId())
                       .createdBy(customer.getCreatedBy())
                       .createdDate(customer.getCreatedDate())
                       .build())
                   .collect(Collectors.toList());

       }
       return null;
    }
}
