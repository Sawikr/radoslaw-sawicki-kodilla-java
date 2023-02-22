package com.kodilla.good.pattern.challengesOrderService;

<<<<<<< HEAD
import com.kodilla.good.pattern.challengesOrderService.anotherVersion.ProductOne;
import com.kodilla.good.pattern.challengesOrderService.anotherVersion.ProductTwo;
=======
>>>>>>> origin/master
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<String> newList = new ArrayList<>();

    public List<String> order() {
<<<<<<< HEAD
        ProductOne productOne = new ProductOne("Computer-AXN55G");
        newList.add(String.valueOf(productOne.getListProduct(productOne)));

        ProductTwo productTwo = new ProductTwo("Computer-GD2");
        newList.add(String.valueOf(productTwo.getListProduct(productTwo)));
=======
        ProductOne productOne = new ProductOne();
        newList.add(String.valueOf(productOne.getListProduct("Computer-AXN55G")));

        ProductTwo productTwo = new ProductTwo();
        newList.add(String.valueOf(productTwo.getListProduct("Computer-GD2")));
>>>>>>> origin/master

        return newList;
    }
}
