package com.kodilla.good.pattern.challengeFood2Door;

public class ProductProducerOne extends Product {

    private final String productName;

    public ProductProducerOne(String productName) {
        super(productName);
        this.productName = productName;
    }

    @Override
    Product getProductName(Product productName) {
        return productName;
    }

    @Override
    public String toString() {
        return "ProductProducerOne {" +
                "productName = '" + productName + '\'' +
                '}';
    }
}
