package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private Shape shape;
    private boolean counter;

    protected List<Shape> shapes = new ArrayList<>();

    public ShapeCollector() {
    }

    public boolean isCounter() {
        return counter;
    }

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public void removeFigure(Shape shape){
        shapes.remove(shape);
    }

    public Shape getFigure(int n){
        return shapes.get(n);
    }

    public void showFigures() {
        String name = null;
        int field = 0;
        counter = false;
        for (int i = 0; i < shapes.size(); i++) {
            name = shapes.get(i).getShapeName();
            field = shapes.get(i).getField();
            counter = true;
            System.out.println("Shape is: " + name + ", field is: " + field + ", counter: " + counter);
        }
    }
}