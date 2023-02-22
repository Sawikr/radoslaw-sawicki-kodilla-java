package com.kodilla.good.pattern.challengesOrderService.anotherVersion;

import java.util.List;

public abstract class Product {

    private String productName;

    protected abstract List<Product> getListProduct(Product product);

    protected abstract Product getProductName(Product productName);

    public Product(String productName){
        this.productName = productName;
    }
}
