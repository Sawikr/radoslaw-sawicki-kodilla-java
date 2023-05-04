package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExpressDeliveryPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public ExpressDeliveryPizzaOrderDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(15));
    }

    @Override
    public String getDescription() {
        return super.getDescription() +
                ": express delivery";
    }
}
