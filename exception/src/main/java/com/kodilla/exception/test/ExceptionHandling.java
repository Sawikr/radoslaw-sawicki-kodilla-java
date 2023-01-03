package com.kodilla.exception.test;

public class ExceptionHandling{

    public static void main(String[] args) {

        SecondChallenge obj = new SecondChallenge();
        String result = "Unchanged";
        
        try {
            result = obj.probablyIWillThrowException(2.5, 2.0);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.fillInStackTrace() + " equals " + e.getMessage());
        } finally {
            System.out.println("Result is: " + result);
        }
    }
}