package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

@Component
public class Board {

    private final TaskList toDoList;

    private final TaskList inProgressList;

    private final TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;

    }

    public TaskList getToDoList() {
        System.out.println("List toDoList is working!");
        return toDoList;
    }

    public TaskList getInProgressList() {
        System.out.println("List inProgressList is working!");
        return inProgressList;
    }

    public TaskList getDoneList() {
        System.out.println("List doneList is working!");
        return doneList;
    }

}
