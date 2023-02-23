package com.kodilla.good.pattern.challengeFood2Door;

public interface Order {

    void order(Producer producer, Product product, int counter, boolean isOrder);
}
