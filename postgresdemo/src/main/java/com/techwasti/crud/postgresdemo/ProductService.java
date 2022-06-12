package com.techwasti.crud.postgresdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    

    @Autowired
    private ProductRepository productRepository;

     public List<Product> getProducts(){
         
        return (List<Product>) productRepository.findAll();
     }

    //  public List<Product> getProductsByName(String name){

    //     return productRepository.findByProduct_Name(name);

    //  }
}
