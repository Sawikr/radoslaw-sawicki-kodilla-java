package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAddList {

    List<Integer> numbersEvenAndOdd = new ArrayList<>();
    List<Integer> emptyList = new ArrayList<>();

    public void getRandomGenerator() {

        for (int i = 0; i < 10; i++) {
            Random randomGenerator = new Random();
            var random = randomGenerator.nextInt(20);
            numbersEvenAndOdd.add(random);
        }
    }

    @Override
    public String toString() {
        return "RandomAddList{" +
                "numbers=" + numbersEvenAndOdd +
                '}';
    }
}