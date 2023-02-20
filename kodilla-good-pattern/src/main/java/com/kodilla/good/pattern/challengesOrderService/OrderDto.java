package com.kodilla.good.pattern.challengesOrderService;

public class OrderDto {

    public OrderDto(User user, boolean b) {
        System.out.println("\nProduct ordered by: " + user + "\nOrder confirmed: " + b);
    }
}
