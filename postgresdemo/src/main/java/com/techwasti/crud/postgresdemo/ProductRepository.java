package com.techwasti.crud.postgresdemo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // List<Product> findByProduct_Name(String name);

}
