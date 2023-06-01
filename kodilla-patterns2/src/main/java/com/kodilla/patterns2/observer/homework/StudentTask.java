package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StudentTask implements TasksObservable {

    private final List<QueueObserver> queueObservers;
    private final Queue<String> taskLists;
    private final String taskName;

    public StudentTask(String taskName) {
        queueObservers = new ArrayList<>();
        taskLists = new ArrayDeque<>();
        this.taskName = taskName;
    }

    public void addTask(String name) {
        taskLists.add(name);
        notifyTaskObservers();
    }

    @Override
    public void registerTaskObserver(QueueObserver queueObserver) {
        queueObservers.add(queueObserver);
    }

    @Override
    public void notifyTaskObservers() {
        for (QueueObserver queueObserver : queueObservers) {
            queueObserver.updateQueue(this);
        }
    }

    @Override
    public void removeTaskObserver(QueueObserver queueObserver) {
        queueObservers.remove(queueObserver);
    }

    public Queue<String> getTaskLists() {
        return taskLists;
    }

    public String getTaskName() {
        return taskName;
    }
}
