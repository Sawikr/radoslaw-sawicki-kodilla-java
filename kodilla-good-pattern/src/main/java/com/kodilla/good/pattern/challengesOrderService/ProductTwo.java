package com.kodilla.good.pattern.challengesOrderService;

import java.util.ArrayList;
import java.util.List;

public class ProductTwo extends Product {

    public Product productName;
    public List<String> listProduct = new ArrayList<>();

    public ProductTwo() {
        super();
    }

    @Override
    public List<String> getListProduct(String product) {
        listProduct.add(product);
        return listProduct;
    }

    @Override
    public Product getProductName(Product product) {
        return productName;
    }
}
