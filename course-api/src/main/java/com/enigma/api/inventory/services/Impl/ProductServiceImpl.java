package com.enigma.api.inventory.services.Impl;

import com.enigma.api.inventory.entities.Product;
import com.enigma.api.inventory.repositories.ProductRepository;
import com.enigma.api.inventory.repositories.impl.ProductRepositoryImpl;
import com.enigma.api.inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends CommonServiceImpl<Product, Integer> implements ProductService {

    @Autowired
    ProductRepositoryImpl productRepository;

    private ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    public Integer countProduct(){
        return productRepository.count();
    }

    public Integer averageProduct(){
        return productRepository.average();
    }
}
