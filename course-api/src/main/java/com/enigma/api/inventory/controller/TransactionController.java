package com.enigma.api.inventory.controller;

import com.enigma.api.inventory.entities.Product;
import com.enigma.api.inventory.entities.Transaction;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.models.*;
import com.enigma.api.inventory.models.transaction.TransactionRequest;
import com.enigma.api.inventory.models.transaction.TransactionResponse;
import com.enigma.api.inventory.services.ProductService;
import com.enigma.api.inventory.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transaction")
@RestController
public class TransactionController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponsMessage<TransactionResponse> add(@RequestBody TransactionRequest model) {
        Transaction entity = modelMapper.map(model, Transaction.class);
        Product product = productService.findById(model.getProductId());
        entity.setProduct(product);
        entity.setTotalPrice(model.getQuantity() * product.getPrice());
        entity = transactionService.save(entity);
        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponsMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponsMessage<Object> removeById(@PathVariable Integer id) {
        Transaction entity = transactionService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }

    @GetMapping("/count")
    public ResponsMessage countTransaction() {
        Integer entity = transactionService.countTransaction();
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }
    @GetMapping("/average")
    public ResponsMessage averageProduct() {
        Integer entity = transactionService.averageTransaction();
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }
}
