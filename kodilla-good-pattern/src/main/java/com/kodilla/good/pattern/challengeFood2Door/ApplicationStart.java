package com.kodilla.good.pattern.challengeFood2Door;

public class ApplicationStart {

    public static void main(String[] args) {

        ProducerOne producerOne = new ProducerOne("McDonald");
        ProductProducerOne productProducerOne = new ProductProducerOne("BurgerMac");
        producerOne.process(producerOne.getProducerName(producerOne), productProducerOne.getProductName(productProducerOne),
                2, true);

        ProducerTwo producerTwo = new ProducerTwo("McDrive");
        ProductProducerTwo productProducerTwo = new ProductProducerTwo("BurgerMax");
        producerTwo.process(producerTwo.getProducerName(producerTwo), productProducerTwo.getProductName(productProducerTwo),
                101, true);
    }
}