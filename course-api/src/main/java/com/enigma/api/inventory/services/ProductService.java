package com.enigma.api.inventory.services;

import com.enigma.api.inventory.entities.Product;

public interface ProductService extends CommonService<Product, Integer> {
    Integer countProduct();
    Integer averageProduct();
}

