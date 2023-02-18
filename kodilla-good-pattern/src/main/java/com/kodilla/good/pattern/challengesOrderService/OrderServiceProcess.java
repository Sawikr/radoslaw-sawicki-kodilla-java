package com.kodilla.good.pattern.challengesOrderService;

import java.time.LocalDateTime;

public class OrderServiceProcess implements OrderService {

    public static LocalDateTime orderFrom = LocalDateTime.now();
    public static LocalDateTime orderTo = LocalDateTime.now().plusDays(5);

    @Override
    public boolean order(User user, LocalDateTime from, LocalDateTime to) {
        return true;
    }

    public static LocalDateTime getOrderFrom() {
        return orderFrom;
    }

    public static LocalDateTime getOrderTo() {
        return orderTo;
    }
}
