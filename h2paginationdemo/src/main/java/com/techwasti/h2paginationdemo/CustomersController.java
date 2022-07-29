package com.techwasti.h2paginationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:3000/")
public class CustomersController {


    @Autowired
    CustomerService customerService;

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE},
            produces= {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<CustomerDTO> creatCustomer(
     @Valid @RequestBody CustomerDTO customerDTO
    ) throws Exception {
        
        customerDTO.setCreatedDate(new Date());
        customerService.saveCustomer(customerDTO);
        
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @GetMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE},
            produces= {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<List<CustomerDTO>> getCustomers(
           @RequestParam(defaultValue = "5", required = false) 
                  Integer pageSize,
           @RequestParam(defaultValue = "0", required = false) 
                  Integer page
    ) throws Exception {

        Pageable paging  = PageRequest.of(page, pageSize);
       
        List<CustomerDTO> customersDTO=   
              customerService.getAllCustomers(paging);
        
        return new ResponseEntity<>(
              customersDTO, HttpStatus.CREATED);
    }

    @GetMapping(
            path = "/user/{userId}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<List<CustomerDTO>> getCustomersByUserId(
            @PathVariable String userId,
            @RequestParam(defaultValue= "0", required = false)
                   Integer page ,
            @RequestParam(defaultValue= "5", required = false) 
                   Integer pageSize 
   ) throws Exception {
        Pageable paging = PageRequest.of(page, pageSize);
        
        List<CustomerDTO> customersDTOs= 
               customerService.getCustomersByUserId(userId, paging);
        
        return new ResponseEntity<List<CustomerDTO>>( 
               customersDTOs, HttpStatus.ACCEPTED);
    }

}
