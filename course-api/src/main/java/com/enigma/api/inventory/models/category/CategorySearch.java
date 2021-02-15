package com.enigma.api.inventory.models.category;

import com.enigma.api.inventory.models.PageSearch;
import com.enigma.api.inventory.models.validation.Alphabetic;

public class CategorySearch extends PageSearch {

    private String code;

    @Alphabetic
    public String code() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
