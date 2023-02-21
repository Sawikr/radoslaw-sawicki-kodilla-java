package com.kodilla.good.pattern.challengesOrderService;

import java.util.List;

abstract class Product {

    public Product productName;

    abstract List<String> getListProduct(String product);

    abstract Product getProductName(Product productName);

    public Product(){
        this.productName = productName;
    }
}
