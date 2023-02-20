package com.kodilla.good.pattern.challengesOrderService;

public class ApplicationOrder {

    public static void main(String[] args) {

        ProductOrderService productOrderService = new ProductOrderService(new InformationServiceProcess(),
                new OrderServiceProcess(), new OrderRepositoryProcess());

        productOrderService.process(new OrderRequest(new User("Sawik", "Radoslaw Sawicki"),
                OrderServiceProcess.getOrderFrom(), OrderServiceProcess.getOrderTo()),
                new OrderProduct("Computer-AXD15G", "Keyboard-AX5", null));
    }
}
