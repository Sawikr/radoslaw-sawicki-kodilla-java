package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    Board board;

    @Test
    void boardTestSuite() {
        //When & Then
        board.getToDoList();
        board.getInProgressList();
        board.getDoneList();

    }

    @Test
    void testTaskAdd() {
        //Given
        TaskList toDoList = board.getToDoList();
        TaskList inProgressList = board.getInProgressList();
        TaskList doneList = board.getDoneList();

        //When
        toDoList.getTasks(new Task("Radek", "Sawicki"));
        inProgressList.getTasks(new Task("Agnieszka", "Sawicka"));
        doneList.getTasks(new Task("Kasjan", "Sawicki"));

        System.out.println(doneList);

        //Then
        assertFalse(toDoList.tasks.isEmpty());
        assertFalse(inProgressList.tasks.isEmpty());
        assertFalse(doneList.tasks.isEmpty());
    }
}
