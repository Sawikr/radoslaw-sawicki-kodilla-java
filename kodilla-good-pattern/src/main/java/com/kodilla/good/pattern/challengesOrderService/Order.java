package com.kodilla.good.pattern.challengesOrderService;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<String> newList = new ArrayList<>();

    public List<String> order() {
        ProductOne productOne = new ProductOne();
        newList.add(String.valueOf(productOne.getListProduct("Computer-AXN55G")));

        ProductTwo productTwo = new ProductTwo();
        newList.add(String.valueOf(productTwo.getListProduct("Computer-GD2")));

        return newList;
    }
}
