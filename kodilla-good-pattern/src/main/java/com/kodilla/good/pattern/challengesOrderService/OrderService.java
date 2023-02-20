package com.kodilla.good.pattern.challengesOrderService;

import java.time.LocalDateTime;

public interface OrderService {

    boolean order(User user, LocalDateTime from, LocalDateTime to);
}
