package com.kodilla.exception.test;

import java.time.LocalTime;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        double result = 0;
        try {
            result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("An error occurred ArithmeticException: " + e.getMessage() + "!");
        } finally {
            System.out.println("The program ends at: " + LocalTime.now() + "!");
            System.out.println("The result of the program is: " + result + "!");
        }
    }
}