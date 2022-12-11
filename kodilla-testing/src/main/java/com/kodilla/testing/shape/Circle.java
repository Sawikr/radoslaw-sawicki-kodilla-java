package com.kodilla.testing.shape;

public class Circle implements Shape{

    private String circle;
    private int field;

    public Circle(String circle, int field) {
        this.circle = circle;
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return circle;
    }

    @Override
    public int getField() {
        return field;
    }

}
