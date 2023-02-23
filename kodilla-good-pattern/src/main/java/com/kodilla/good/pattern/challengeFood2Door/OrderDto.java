package com.kodilla.good.pattern.challengeFood2Door;

public class OrderDto implements Order {

    private Producer producer;
    private Product product;
    private int counter;
    private boolean isOrder;

    public OrderDto(Producer producer, Product product, int counter, boolean isOrder) {
        this.producer = producer;
        this.product = product;
        this.counter = counter;
        this.isOrder = isOrder;
        order(producer, product, counter, isOrder);
    }

    @Override
    public void order(Producer producer, Product product, int counter, boolean isOrder) {
        System.out.println("Producent: " + producer + "\nProduct: " + product +
                "\nCounter of product: " + counter + "\nOrder status: " + isOrder);
    }
}
