package com.enigma.api.inventory.models.product;

import com.enigma.api.inventory.models.PageSearch;
import com.enigma.api.inventory.models.validation.Alphabetic;

public class ProductSearch extends PageSearch {

    private String name;

    @Alphabetic
    public String name() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}