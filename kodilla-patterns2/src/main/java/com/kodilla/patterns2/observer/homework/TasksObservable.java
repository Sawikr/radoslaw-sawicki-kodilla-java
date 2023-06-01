package com.kodilla.patterns2.observer.homework;

public interface TasksObservable {

    void registerTaskObserver(QueueObserver queueObserver);

    void notifyTaskObservers();

    void removeTaskObserver(QueueObserver queueObserver);
}
