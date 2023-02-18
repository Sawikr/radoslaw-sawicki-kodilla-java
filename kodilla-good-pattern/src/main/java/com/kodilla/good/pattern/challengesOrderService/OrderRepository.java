package com.kodilla.good.pattern.challengesOrderService;

import java.time.LocalDateTime;

public interface OrderRepository {

    void createOrder(User user, OrderProduct orderProduct, LocalDateTime from, LocalDateTime to);
}
