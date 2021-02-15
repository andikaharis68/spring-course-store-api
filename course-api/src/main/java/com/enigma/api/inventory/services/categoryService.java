package com.enigma.api.inventory.services;

import com.enigma.api.inventory.entities.Category;

public interface categoryService extends CommonService<Category, Integer> {
    Integer countCategory();
}
