package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private String triangle;
    private int field;

    public Triangle(String triangle, int field) {
        this.triangle = triangle;
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return triangle;
    }

    @Override
    public int getField() {
        return field;
    }
}
