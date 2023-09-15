package com.programmeringtechie.productservice.repository;

import com.programmeringtechie.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String>{
}
