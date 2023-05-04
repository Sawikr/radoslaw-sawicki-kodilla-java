package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaOrderGetCost() {
        // Given
        Pizza theOrder = new PizzaOrder();

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testPizzaOrderGetDescription() {
        // Given
        Pizza theOrder = new PizzaOrder();

        // When
        String description = theOrder.getDescription();

        // Then
        assertEquals("Pizza: dough and tomato sauce with cheese", description);
    }

    @Test
    public void testHawaiianPizzaOrderGetCost() {
        // Given
        Pizza theOrder = new PizzaOrder();
        theOrder = new HawaiianPizzaOrderDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(35), calculatedCost);
    }

    @Test
    public void testHawaiianPizzaOrderGetDescription() {
        // Given
        Pizza theOrder = new PizzaOrder();
        theOrder = new HawaiianPizzaOrderDecorator(theOrder);

        // When
        String description = theOrder.getDescription();

        // Then
        assertEquals("Pizza: dough and tomato sauce with cheese" +
                " and additional ingredients: ham, mozzarella cheese, canned pineapple", description);
    }

    @Test
    public void testKebabPizzaOrderGetCost() {
        // Given
        Pizza theOrder = new PizzaOrder();
        theOrder = new KebabPizzaOrderDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(40), calculatedCost);
    }

    @Test
    public void testKebabPizzaOrderGetDescription() {
        // Given
        Pizza theOrder = new PizzaOrder();
        theOrder = new KebabPizzaOrderDecorator(theOrder);

        // When
        String description = theOrder.getDescription();

        // Then
        assertEquals("Pizza: dough and tomato sauce with cheese" +
                " and additional ingredients: chicken, mushrooms, corn, cucumbers, peppers, onions, and grated cheese",
                description);
    }

    @Test
    public void testKebabPizzaOrderWithExpressDeliveryAndVipPizzaGetCost() {
        // Given
        Pizza theOrder = new PizzaOrder();
        theOrder = new KebabPizzaOrderDecorator(theOrder);
        theOrder = new ExpressDeliveryPizzaOrderDecorator(theOrder);
        theOrder = new VipPizzaOrderDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(65), calculatedCost);
    }

    @Test
    public void testKebabPizzaOrderWithExpressDeliveryAndVipPizzaGetDescription() {
        // Given
        Pizza theOrder = new PizzaOrder();
        theOrder = new KebabPizzaOrderDecorator(theOrder);
        theOrder = new ExpressDeliveryPizzaOrderDecorator(theOrder);
        theOrder = new VipPizzaOrderDecorator(theOrder);

        // When
        String description = theOrder.getDescription();

        // Then
        assertEquals("Pizza: dough and tomato sauce with cheese" +
                " and additional ingredients: chicken, mushrooms, corn, cucumbers, peppers, onions, and grated cheese" +
                ": express delivery" + ": variant VIP",
                description);
    }
}
