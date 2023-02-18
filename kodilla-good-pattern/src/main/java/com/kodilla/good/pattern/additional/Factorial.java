package com.kodilla.good.pattern.additional;

public class Factorial {

    public static void main(String[] args) {

        int f = 4;
        System.out.println("Factorial number " + f + " is: " + getFactorialOne(f));
        System.out.println("Factorial number " + f + " is: " + getFactorialTwo(f));
    }

    public static int getFactorialOne(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * getFactorialOne(f - 1);
        }
    }

    public static int getFactorialTwo(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}
