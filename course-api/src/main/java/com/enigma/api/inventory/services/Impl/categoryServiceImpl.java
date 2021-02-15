package com.enigma.api.inventory.services.Impl;

import com.enigma.api.inventory.entities.Category;
import com.enigma.api.inventory.repositories.CategoryRepository;
import com.enigma.api.inventory.repositories.impl.CategoryRepositoryImpl;
import com.enigma.api.inventory.services.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoryServiceImpl extends CommonServiceImpl<Category, Integer> implements categoryService {

    @Autowired
    CategoryRepositoryImpl categoryRepository;

    private categoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    public Integer countCategory(){
        return categoryRepository.count();
    }
}
