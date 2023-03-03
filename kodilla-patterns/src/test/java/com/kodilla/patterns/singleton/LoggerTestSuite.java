package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

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

    @DisplayName("Name of test: loggerTestSuite")
    @Test
    void loggerTestSuite() {
        //Given
        Logger logger = new Logger();

        //When
        logger.log("New logger");

        //Then
        assertEquals("New logger", logger.getLastLog());
    }

    @DisplayName("Name of test: loggerTestSuiteSingleton")
    @Test
    void loggerTestSuiteSingleton() {
        //Given
        LoggerSingleton logger = LoggerSingleton.INSTANCE;

        //When
        logger.log("New loggerSingleton");

        //Then
        assertEquals("New loggerSingleton", logger.getLastLog());
    }
}
