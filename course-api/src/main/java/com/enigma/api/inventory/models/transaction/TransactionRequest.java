package com.enigma.api.inventory.models.transaction;

import javax.validation.constraints.NotNull;

public class TransactionRequest {

    @NotNull
    private Integer productId;

    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
