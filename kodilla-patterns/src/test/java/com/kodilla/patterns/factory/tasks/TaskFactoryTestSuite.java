package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("Name of test: testTaskFactoryTestSuiteShoppingTask")
    @Test
    void testTaskFactoryTestSuiteShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shoppingTask = taskFactory.makeShape(TaskFactory.SHOPPING_TASK);

        //Then
        assertEquals("ShoppingTask", shoppingTask.getTaskName());
        assertTrue(shoppingTask.executeTask());
        assertTrue(shoppingTask.isTaskExecuted());

    }

    @DisplayName("Name of test: testTaskFactoryTestSuitePaintingTask")
    @Test
    void testTaskFactoryTestSuitePaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task paintingTask = taskFactory.makeShape(TaskFactory.PAINTING_TASK);

        //Then
        assertEquals("PaintingTask", paintingTask.getTaskName());
        assertTrue(paintingTask.executeTask());
        assertTrue(paintingTask.isTaskExecuted());

    }

    @DisplayName("Name of test: testTaskFactoryTestSuiteDrivingTask")
    @Test
    void testTaskFactoryTestSuiteDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task drivingTask = taskFactory.makeShape(TaskFactory.DRIVING_TASK);

        //Then
        assertEquals("DrivingTask", drivingTask.getTaskName());
        assertTrue(drivingTask.executeTask());
        assertTrue(drivingTask.isTaskExecuted());

    }
}
