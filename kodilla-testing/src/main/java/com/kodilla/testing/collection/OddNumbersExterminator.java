package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    Boolean methodWorking = false;

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> numbersEven = new ArrayList<>();//Mt: inside the method!
        for (int i = 0; i < numbers.size(); i++) {
            var item = numbers.get(i);
            if (item % 2 == 0) {
                numbersEven.add(item);
            }else
                numbersEven.remove(item);
        }
        methodWorking = true;
        System.out.println("Method is working: methodWorking is " + methodWorking + "!");
        return numbersEven;
    }
}