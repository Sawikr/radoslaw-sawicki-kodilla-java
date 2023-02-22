package com.kodilla.good.pattern.challengesOrderService.anotherVersion;

import java.util.ArrayList;
import java.util.List;

public class ProductOne extends Product {

    private String productName;
    private List<Product> listProduct = new ArrayList<>();

    public ProductOne(String productName) {
        super(productName);
        this.productName = productName;

    }

    @Override
    public List<Product> getListProduct(Product product) {
        listProduct.add(product);
        return listProduct;
    }

    @Override
    protected Product getProductName(Product product) {
        return product;
    }

    @Override
    public String toString() {
        return "ProductOne {" +
                "productName ='" + productName + '\'' +
                '}';
    }
}
