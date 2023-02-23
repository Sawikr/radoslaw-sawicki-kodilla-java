package com.kodilla.good.pattern.challengeFood2Door;

public class ProducerTwo extends Producer implements OrderProcess {

    private final String producerName;

    public ProducerTwo(String producerName) {
        super(producerName);
        this.producerName = producerName;
    }

    @Override
    protected Producer getProducerName(Producer producerName) {
        return producerName;
    }

    @Override
    public void process(Producer producer, Product product, int counter, boolean isOrder) {
        if (isOrder) {
            if (counter > 100) {
                isOrder = false;
                new OrderDto(producer, product, counter, isOrder);
                System.out.println("No products in stock!");
            } else {
                new OrderDto(producer, product, counter, isOrder);
            }
        }
        else {
            new OrderDto(producer, product, counter, isOrder);
        }
        System.out.println();
    }



    @Override
    public String toString() {
        return "ProducerTwo {" +
                "producerName = '" + producerName + '\'' +
                '}';
    }
}
