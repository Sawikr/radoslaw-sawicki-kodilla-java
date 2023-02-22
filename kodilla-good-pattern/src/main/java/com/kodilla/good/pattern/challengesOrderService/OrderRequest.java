package com.kodilla.good.pattern.challengesOrderService;

import java.time.LocalDateTime;

public class OrderRequest {

    private final User user;

    public OrderRequest(User user, LocalDateTime from, LocalDateTime to) {
        this.user = user;
        OrderServiceProcess.orderFrom = from;
        OrderServiceProcess.orderTo = to;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getFrom() {
        return OrderServiceProcess.orderFrom;
    }

    public LocalDateTime getTo() {
        return OrderServiceProcess.orderTo;
    }
}
