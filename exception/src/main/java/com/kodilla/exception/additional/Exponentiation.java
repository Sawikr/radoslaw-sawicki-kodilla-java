package com.kodilla.exception.additional;

import java.util.Scanner;

public class Exponentiation {

    public static void main (String[] args) throws java.lang.Exception
    {
        long a, b, c;
        long result = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number (base of power):");
        a = scanner.nextInt();
        System.out.println("Enter number (exponent):");
        b = scanner.nextInt();
        c = b;

        //Method: exponentiation
        while(b > 0)
        {
            result *= a;
            b--;
        }

        System.out.println("The " + a + " raised to the " + c + " is: " + result);
    }
}