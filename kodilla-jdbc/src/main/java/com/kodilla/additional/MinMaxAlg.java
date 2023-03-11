package com.kodilla.additional;

import java.util.Arrays;
import java.util.OptionalInt;

public class MinMaxAlg {

    public static void main(String [] args) {

        int [] tab = {3,1,5,6,7,9,15,3,4,7,10};

        System.out.println("Solution is: " + min(tab));
        System.out.println("Solution is: " + max(tab));

        //Another solution
        OptionalInt valMin = Arrays.stream(tab).min();
        OptionalInt valMax = Arrays.stream(tab).max();
        System.out.println("min: " + valMin);
        System.out.println("max: " + valMax);
    }

    public static int max (int [] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++ ) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public static int min (int [] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++ ) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
