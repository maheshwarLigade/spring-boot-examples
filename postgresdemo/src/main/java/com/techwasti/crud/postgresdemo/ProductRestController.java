package com.techwasti.crud.postgresdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;







@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;


    @GetMapping(value="/getProducts")
    public ResponseEntity<List<Product>> getMethodName() {

        return ResponseEntity.ok(productService.getProducts());

    }
         

}
