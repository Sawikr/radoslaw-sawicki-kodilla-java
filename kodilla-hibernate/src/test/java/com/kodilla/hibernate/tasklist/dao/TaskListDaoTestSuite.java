package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(1, "ListOne", DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        String listName = taskList.getListName();
        List<TaskList> readTask = taskListDao.findByListName(listName);
        assertEquals(listName, readTask.get(0).getListName());

        //CleanUp
        taskListDao.deleteByListName(taskList.getListName());
    }
}