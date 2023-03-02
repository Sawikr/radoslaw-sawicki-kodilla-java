package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskList {

    List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void getTasks(Task task) {
        tasks.add(task.toString());
    }

    @Override
    public String toString() {
        return "TaskList {" +
                "tasks = " + tasks +
                '}';
    }
}
