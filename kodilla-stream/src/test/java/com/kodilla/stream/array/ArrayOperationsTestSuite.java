package com.kodilla.stream.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite implements ArrayOperations{

    private static final Logger LOGGER = Logger.getLogger(ArrayOperationsTestSuite.class.getName());
    private static int testCounter = 0;
    private static int[] names;

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!\n");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    public double getAverage(int[] numbers){
        System.out.println("Array element names: ");
        IntStream.range(0, numbers.length).forEach(System.out::println);

        double result = IntStream.range(0, numbers.length).average().getAsDouble();
        LOGGER.info("Average is: " + result);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayOperationsTestSuite{" +
                "names=" + Arrays.toString(names) +
                '}';
    }

    @DisplayName("Name of test: testGetAverage")
    @Test
    void testGetAverage(){
        //Given
        int[] names = new int[20];
        //filling an array with values
        for(int i=0; i < 20; i++) {
            names[i] = i;
        }

        //When
        ArrayOperationsTestSuite obj = new ArrayOperationsTestSuite();
        double result = obj.getAverage(names);

        //Then
        assertEquals(9.5, result);
    }
}