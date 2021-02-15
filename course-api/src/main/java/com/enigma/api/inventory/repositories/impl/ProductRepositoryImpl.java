package com.enigma.api.inventory.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductRepositoryImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer count() {
        Integer productCount = jdbcTemplate.queryForObject("SELECT count(id) FROM product", Integer.class);
        return productCount;
    }

    public Integer average() {
        Integer productAvg = jdbcTemplate.queryForObject("SELECT AVG(price) FROM product", Integer.class);
        return productAvg;
    }
}
