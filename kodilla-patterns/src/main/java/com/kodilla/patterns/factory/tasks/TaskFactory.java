package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeShape(final String tasksClass) {
        return switch (tasksClass) {
            case SHOPPING_TASK -> new ShoppingTask("ShoppingTask", "Computer", 1.0);
            case PAINTING_TASK -> new PaintingTask("PaintingTask", "Red", "Picture");
            case DRIVING_TASK -> new DrivingTask("DrivingTask", "Poznan", "Auto");
            default -> null;
        };
    }
}
