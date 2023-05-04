package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HawaiianPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public HawaiianPizzaOrderDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(20));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " and additional ingredients: ham, mozzarella cheese, canned pineapple";
    }
}
