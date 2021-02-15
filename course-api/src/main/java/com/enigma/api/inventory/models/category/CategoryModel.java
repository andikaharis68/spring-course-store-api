package com.enigma.api.inventory.models.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryModel {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String code;

    @NotBlank
    @Size(min = 1, max = 100)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UnitModel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
