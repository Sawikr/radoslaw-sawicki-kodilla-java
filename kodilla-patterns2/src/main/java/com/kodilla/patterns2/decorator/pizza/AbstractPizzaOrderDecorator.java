package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaOrderDecorator implements Pizza {

    private final Pizza pizza;

    public AbstractPizzaOrderDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public BigDecimal getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
