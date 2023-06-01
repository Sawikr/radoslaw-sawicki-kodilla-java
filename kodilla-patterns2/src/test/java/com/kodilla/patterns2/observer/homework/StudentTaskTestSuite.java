package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTaskTestSuite {

    @Test
    public void testUpdate() {
        //Given
        StudentTask javaCourse = new JavaCourse();
        StudentTask ccCourse = new CcCourse();
        StudentTask pythonCourse = new PythonCourse();
        Mentor janKowalski = new Mentor("Jan Kowalski");
        Mentor radekSawicki = new Mentor("Radek Sawicki");
        Mentor kamilSawicki = new Mentor("Kamil Sawicki");
        javaCourse.registerTaskObserver(janKowalski);
        pythonCourse.registerTaskObserver(radekSawicki);
        ccCourse.registerTaskObserver(janKowalski);
        ccCourse.registerTaskObserver(radekSawicki);
        javaCourse.registerTaskObserver(kamilSawicki);

        //When
        javaCourse.addTask("First Task");
        javaCourse.addTask("Second Task");
        ccCourse.addTask("First Task introduce C++");
        pythonCourse.addTask("Learn python simple task");
        pythonCourse.addTask("Second task");
        pythonCourse.addTask("Add dependency task");

        //Then
        assertEquals(3, janKowalski.getUpdateCount());
        assertEquals(4, radekSawicki.getUpdateCount());
        assertEquals(2, kamilSawicki.getUpdateCount());
    }
}