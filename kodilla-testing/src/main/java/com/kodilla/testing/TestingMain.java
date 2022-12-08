package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //Task 6.2
        System.out.println("\nUnit test - task 6.2:");

        Calculator calculator = new Calculator();
        int resultUnitTestAdd = calculator.add(2, 2);
        int resultUnitTestSubtract = calculator.subtract(2, 2);

        if (resultUnitTestAdd == 4 && resultUnitTestSubtract == 0) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}