package com.kodilla.good.pattern.challengesOrderService;

import com.kodilla.good.pattern.challengesOrderService.anotherVersion.ProductOne;
import com.kodilla.good.pattern.challengesOrderService.anotherVersion.ProductTwo;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<String> newList = new ArrayList<>();

    public List<String> order() {
        ProductOne productOne = new ProductOne("Computer-AXN55G");
        newList.add(String.valueOf(productOne.getListProduct(productOne)));

        ProductTwo productTwo = new ProductTwo("Computer-GD2");
        newList.add(String.valueOf(productTwo.getListProduct(productTwo)));

        return newList;
    }
}
