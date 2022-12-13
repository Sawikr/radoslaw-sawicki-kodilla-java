package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;


@DisplayName("CollectionTestSuite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!\n");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("\nTest testOddNumbersExterminatorEmptyList and testOddNumbersExterminatorNormalLis " +
                "begin!");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test testOddNumbersExterminatorEmptyList and testOddNumbersExterminatorNormalLis "
                + "end!\n");
    }


    @DisplayName("Name of test: testOddNumbersExterminatorEmptyList")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> numbersEvenAndOdd = new ArrayList<>();
        //List<Integer> numbersEvenAndOdd = List.of(1, 6, 3);
        numbersEvenAndOdd.add(1);
        numbersEvenAndOdd.add(6);
        numbersEvenAndOdd.add(3);
        numbersEvenAndOdd.add(9);
        numbersEvenAndOdd.add(4);
        numbersEvenAndOdd.add(8);

        OddNumbersExterminator listEven = new OddNumbersExterminator();


        //Mt: don't use random values and loops in your tests
        /*
        RandomAddList listEvenAndOdd = new RandomAddList();
        listEvenAndOdd.getRandomGenerator();

        System.out.println("List with even and odd numbers:");
        for (int i = 0; i < listEvenAndOdd.numbersEvenAndOdd.size(); i++) {
            int numb = listEvenAndOdd.numbersEvenAndOdd.get(i);
            System.out.println("The number on the list is: " + numb);
        }

        OddNumbersExterminator listEven = new OddNumbersExterminator();
        listEven.exterminate(listEvenAndOdd.numbersEvenAndOdd);

        System.out.println("\nList with even numbers:");
        for (int i = 0; i < listEven.numbersEven.size(); i++) {
            int numb = listEven.numbersEven.get(i);
            System.out.println("The number on the list is: " + numb);
        }*/

        //When
        listEven.exterminate(numbersEvenAndOdd);

        //Then
        Assertions.assertFalse(listEven.exterminate(numbersEvenAndOdd).isEmpty());

    }

    @DisplayName("Name of test: testOddNumbersExterminatorNormalList")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> numbersEvenAndOdd = new ArrayList<>();
        numbersEvenAndOdd.add(1);
        numbersEvenAndOdd.add(6);
        numbersEvenAndOdd.add(3);
        numbersEvenAndOdd.add(9);
        numbersEvenAndOdd.add(4);
        numbersEvenAndOdd.add(8);

        OddNumbersExterminator listEven = new OddNumbersExterminator();

        //When
        listEven.exterminate(numbersEvenAndOdd);

        //Then
        Assertions.assertEquals(true, listEven.methodWorking);

    }
}