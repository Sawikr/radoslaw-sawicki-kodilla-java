package com.kodilla.good.pattern.challengesOrderService;

public class InformationServiceProcess implements InformationService{

    @Override
    public void inform(User user, OrderProduct orderProduct) {
        System.out.println("\nDetails of the order: " +
                "\nUser: " + user +
                "\nProduct name: " + orderProduct.getProductOne() +
                ", " + orderProduct.getProductTwo() + ", " + orderProduct.getProductThree());
    }
}
