package com.kodilla.good.pattern.challengeFood2Door;

abstract class Product {

    private String productName;

    abstract Product getProductName(Product productName);

    public Product(String productName){
        this.productName = productName;
    }
}
