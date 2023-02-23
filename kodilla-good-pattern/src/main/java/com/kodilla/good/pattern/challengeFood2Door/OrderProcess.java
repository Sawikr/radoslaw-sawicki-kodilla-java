package com.kodilla.good.pattern.challengeFood2Door;

public interface OrderProcess {

    void process(Producer producer, Product product, int counter, boolean isOrder);
}
