package com.kodilla.good.pattern.challengesOrderService;

import java.util.List;

public class OrderProduct {

    private final List<String> order;

    public OrderProduct(List<String> order) {
        this.order = order;

    }
    public List<String> getProducts() {
        return order;
    }
}
