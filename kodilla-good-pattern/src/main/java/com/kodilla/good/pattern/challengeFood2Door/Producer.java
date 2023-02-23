package com.kodilla.good.pattern.challengeFood2Door;

public abstract class Producer {

    private String producerName;

    protected abstract Producer getProducerName(Producer producerName);

    public Producer(String producerName){
        this.producerName = producerName;
    }
}
