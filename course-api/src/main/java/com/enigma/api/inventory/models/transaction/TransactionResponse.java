package com.enigma.api.inventory.models.transaction;

import com.enigma.api.inventory.models.product.ProductRequest;

public class TransactionResponse {
    private Integer id;

    private ProductRequest product;

    private Integer quantity;

    private Integer totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductRequest getProduct() {
        return product;
    }

    public void setProduct(ProductRequest product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
