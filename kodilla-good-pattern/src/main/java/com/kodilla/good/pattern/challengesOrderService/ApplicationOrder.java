package com.kodilla.good.pattern.challengesOrderService;

public class ApplicationOrder {

    public static void main(String[] args) {

        ProductOrderService productOrderService = new ProductOrderService(new InformationServiceProcess(),
                new OrderServiceProcess(), new OrderRepositoryProcess());

        Order order = new Order();

        productOrderService.process(new OrderRequest(new User("Sawik", "Radoslaw Sawicki"),
                OrderServiceProcess.getOrderFrom(), OrderServiceProcess.getOrderTo()),
                new OrderProduct(order.order()));
    }
}