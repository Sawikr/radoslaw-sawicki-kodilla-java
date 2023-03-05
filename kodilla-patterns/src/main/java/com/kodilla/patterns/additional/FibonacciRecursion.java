package com.kodilla.patterns.additional;

import java.util.Scanner;

public class FibonacciRecursion {

    public static int fibRecursion(int n) {
        if ((n == 1)||(n == 2))
            return 1;
        else
            return fibRecursion(n-1) + fibRecursion(n-2);
    }

    public static int fibLoop(int n) {
        int number1 = 0;
        int number2 = 1;
        int sum;
        int total = n;

        for (int i = 1; i < total; ++i) {
            sum = number1 + number2;
            number1 = number2;
            number2 = sum;
        }
        return number2;
    }

    public static void main(String[] args) {

        System.out.println("Specify which term of the Fibonacci sequence to calculate?");
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.next());
        System.out.println("FibRecursion: " + n + "-th term of the Fibonacci sequence: " + fibRecursion(n));
        System.out.println("FibLoop: " + n + "-th term of the Fibonacci sequence: " + fibLoop(n));
    }
}
