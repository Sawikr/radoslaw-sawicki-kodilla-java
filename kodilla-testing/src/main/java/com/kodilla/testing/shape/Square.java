package com.kodilla.testing.shape;

public class Square implements Shape{

    private String square;
    private int field;

    public Square(String square, int field) {
        this.square = square;
        this.field = field;
    }

    @Override
    public String getShapeName() {
         return square;
    }

    @Override
    public int getField() {
         return field;
    }
}
