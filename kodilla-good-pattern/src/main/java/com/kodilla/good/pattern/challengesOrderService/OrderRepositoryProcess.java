package com.kodilla.good.pattern.challengesOrderService;

import java.time.LocalDateTime;

public class OrderRepositoryProcess implements OrderRepository{

    @Override
    public void createOrder(User user, OrderProduct orderProduct, LocalDateTime from, LocalDateTime to) {
        System.out.println("\nThe order has been saved in the database for execution:" +
                "\nUser: " + user +
                ", product: " + orderProduct.getProductOne() +
                ", " + orderProduct.getProductTwo() + ", " + orderProduct.getProductThree() +
                ", from: " + from +
                ", to: " + to);
    }
}
