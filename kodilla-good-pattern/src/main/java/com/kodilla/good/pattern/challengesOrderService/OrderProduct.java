package com.kodilla.good.pattern.challengesOrderService;

public class OrderProduct {

    private final String productOne;
    private final String productTwo;
    private final String productThree;

    public OrderProduct(String productOne, String productTwo, String productThree) {
        this.productOne = productOne;
        this.productTwo = productTwo;
        this.productThree = productThree;
    }

    public String getProductOne() {
        return productOne;
    }

    public String getProductTwo() {
        return productTwo;
    }

    public String getProductThree() {
        return productThree;
    }
}
