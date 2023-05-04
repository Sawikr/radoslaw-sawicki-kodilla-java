package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class KebabPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public KebabPizzaOrderDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(25));
    }

    @Override
    public String getDescription() {
        return super.getDescription() +
                " and additional ingredients: chicken, mushrooms, corn, cucumbers, peppers, onions, and grated cheese";
    }
}
