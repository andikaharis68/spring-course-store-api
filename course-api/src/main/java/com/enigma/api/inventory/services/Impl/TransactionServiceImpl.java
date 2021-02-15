package com.enigma.api.inventory.services.Impl;

import com.enigma.api.inventory.entities.Transaction;
import com.enigma.api.inventory.repositories.TransactionRepository;
import com.enigma.api.inventory.repositories.impl.ProductRepositoryImpl;
import com.enigma.api.inventory.repositories.impl.TransactionRepositoryImpl;
import com.enigma.api.inventory.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CommonServiceImpl<Transaction, Integer> implements TransactionService {

    @Autowired
    TransactionRepositoryImpl transactionRepository;

    private TransactionServiceImpl(TransactionRepository repository){
        super(repository);
    }

    public Integer countTransaction(){
        return transactionRepository.count();
    }

    public Integer averageTransaction(){
        return transactionRepository.average();
    }
}
