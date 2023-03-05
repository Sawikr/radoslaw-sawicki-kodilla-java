package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("Name of test: testBigmacTestSuite")
    @Test
    void testBigmacTestSuite() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .getBun("MacBun")
                .getBurgers(2)
                .getSauce("Standard")
                .getIngredients("Salad")
                .getIngredients("Bacon")
                .getIngredients("Cucumber")
                .build();

        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        Bigmac.BigmacBuilder bigmacBuilder = new Bigmac.BigmacBuilder();
        Bigmac.BigmacBuilder howManyBurgers = bigmacBuilder.getBurgers(2);

        //Then
        assertEquals(3, howManyIngredients);
        assertEquals(Bigmac.BigmacBuilder.class, howManyBurgers.getClass());
    }

    @DisplayName("Name of test: testBigmacTestSuiteIsCorrect")
    @Test
    void testBigmacTestSuiteIsCorrect() {
        //Given
        Bigmac bigmac = null;
        try {
            bigmac = getBigmac();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
        }

        //When & then
        assertNull(bigmac);
    }

    private Bigmac getBigmac() {
        return new Bigmac.BigmacBuilder()
                .getBun("MacBun")
                .getIngredients("Bacon")
                .build();
    }
}
