package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaOrder implements Pizza {

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15);
    }

    @Override
    public String getDescription() {
        return "Pizza: dough and tomato sauce with cheese";
    }
}
