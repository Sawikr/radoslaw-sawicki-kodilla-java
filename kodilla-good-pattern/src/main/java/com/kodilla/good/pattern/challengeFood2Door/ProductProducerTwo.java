package com.kodilla.good.pattern.challengeFood2Door;

public class ProductProducerTwo extends Product {

    private final String productName;

    public ProductProducerTwo(String productName) {
        super(productName);
        this.productName = productName;
    }

    @Override
    Product getProductName(Product productName) {
        return productName;
    }

    @Override
    public String toString() {
        return "ProductProducerTwo {" +
                "productName = '" + productName + '\'' +
                '}';
    }
}
