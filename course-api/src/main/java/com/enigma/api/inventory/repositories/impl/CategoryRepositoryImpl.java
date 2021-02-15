package com.enigma.api.inventory.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryRepositoryImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer count() {
        Integer categoryCount = jdbcTemplate.queryForObject("SELECT count(id) FROM category", Integer.class);
        return categoryCount;
    }
}
