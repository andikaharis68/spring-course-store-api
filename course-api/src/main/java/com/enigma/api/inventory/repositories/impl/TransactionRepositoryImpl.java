package com.enigma.api.inventory.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransactionRepositoryImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer count() {
        Integer transactionCount = jdbcTemplate.queryForObject("SELECT count(id) FROM transaction", Integer.class);
        return transactionCount;
    }

    public Integer average() {
        Integer transactionAvg = jdbcTemplate.queryForObject("SELECT AVG(quantity) FROM transaction", Integer.class);
        return transactionAvg;
    }
}
