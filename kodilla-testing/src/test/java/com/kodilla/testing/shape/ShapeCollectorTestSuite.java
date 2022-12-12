package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;


@DisplayName("ShapeCollectorTestSuite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!\n");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("\nTest ShapeCollectorTestSuite " +
                "begin!");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test ShapeCollectorTestSuite "
                + "end!\n");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Name of test: testAddFigure and testRemoveFigure")
    class AddRemoveFigure {

        @DisplayName("Name of test: testAddFigure")
        @Test
        void testAddFigure() {
            //Given
            Square shape = new Square("Square", 10);

            //When
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Square("Square", 10));

            //Then
            Assertions.assertFalse(shapeCollector.shapes.isEmpty());

        }

        @DisplayName("Name of test: testRemoveFigure")
        @Test
        void testRemoveFigure() {
            //Given
            Square shape = new Square("Square", 10);

            //When
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.removeFigure(new Square("Square", 10));

            //Then
            Assertions.assertTrue(shapeCollector.shapes.isEmpty());

        }
    }

    @Nested
    @DisplayName("Name of test: getFigure and showFigures")

    class GetFigure {
        @DisplayName("Name of test: getFigure")
        @Test
        void getFigure() {
            //Given
            Triangle triangle = new Triangle("Triangle", 5);

            //When
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Triangle("Triangle", 10));
            shapeCollector.addFigure(new Triangle("TriangleNew", 20));

            Shape getFigure = shapeCollector.getFigure(1);

            //Then
            Assertions.assertEquals(shapeCollector.shapes.get(1), getFigure);

        }

        @DisplayName("Name of test: getFigureIndexMinusZero")
        @Test
        void getFigureIndexMinusZero() {
            //Given
            Triangle triangle = new Triangle("Triangle", 5);

            //When
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Triangle("Triangle", 10));
            shapeCollector.addFigure(new Triangle("TriangleNew", 20));

            Shape getFigure = null;
            try{
                getFigure = shapeCollector.getFigure(-1);
            }catch (IndexOutOfBoundsException e) {
                System.out.println("Exception thrown  :" + e);
            }
            Exception ex = new Exception();

            //Then
            Assertions.assertEquals(getFigure, ex.getMessage());

        }

        @DisplayName("Name of test: getFigureIndexAboveBound")
        @Test
        void getFigureIndexAboveBound() {
            //Given
            Triangle triangle = new Triangle("Triangle", 5);

            //When
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Triangle("Triangle", 10));
            shapeCollector.addFigure(new Triangle("TriangleNew", 20));

            Shape getFigure = null;
            try{
                getFigure = shapeCollector.getFigure(3);
            }catch (IndexOutOfBoundsException e) {
                System.out.println("Exception thrown  :" + e);
            }
            Exception ex = new Exception();

            //Then
            Assertions.assertEquals(getFigure, ex.getMessage());

        }

    }

        @DisplayName("Name of test: showFigures")
        @Test
        void showFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.shapes.add(new Circle("Circle", 5));
            shapeCollector.shapes.add(new Triangle("Triangle", 10));
            shapeCollector.shapes.add(new Circle("CircleNew", 10));

            //When
            shapeCollector.showFigures();

            //Then
            Assertions.assertEquals(true, shapeCollector.isCounter());
            //Assertions.assertTrue(shapeCollector.isCounter() == true);//other solution

        }
}