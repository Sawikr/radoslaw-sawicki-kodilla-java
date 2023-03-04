package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuiteStrategySocial {

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

    @DisplayName("Name of test: testDefaultSharingStrategies")
    @Test
    void testDefaultSharingStrategies() {
        //Given
        Millenials millenials = new Millenials("John");
        YGeneration yGeneration = new YGeneration("Jessica");
        ZGeneration zGeneration = new ZGeneration("Kasjan");

        //When
        String johnUses = millenials.sharePost();
        System.out.println("John uses " + johnUses);
        String jessicaUses = yGeneration.sharePost();
        System.out.println("Jessica uses " + jessicaUses);
        String kasjanUses = zGeneration.sharePost();
        System.out.println("Kasjan uses " + kasjanUses);

        //Then
        assertEquals("Snapchat", johnUses);
        assertEquals("Facebook", jessicaUses);
        assertEquals("Twitter", kasjanUses);

    }

    @DisplayName("Name of test: testIndividualSharingStrategy")
    @Test
    void testIndividualSharingStrategy() {
        //Given
        Millenials millenials = new Millenials("John");

        //When
        String johnUses = millenials.sharePost();
        System.out.println("John uses " + johnUses);

        millenials.setSocialPublisher(new TwitterPublisher());
        johnUses = millenials.sharePost();
        System.out.println("John uses " + johnUses);

        //Then
        assertEquals("Twitter", johnUses);

    }
}
