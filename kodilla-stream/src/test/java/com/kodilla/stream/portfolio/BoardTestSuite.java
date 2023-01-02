package com.kodilla.stream.portfolio;

import com.kodilla.stream.world.WorldTestSuite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTestSuite {

    private static final Logger LOGGER = Logger.getLogger(WorldTestSuite.class.getName());
    private static int testCounter = 0;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!\n");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("Name of test: testAddTaskListAverageWorkingOnTask")
    @Test
    void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        double averageDaysSum = project.getTaskLists().stream()
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .map(BoardTestSuite::betweenDays)//Other here
                .reduce(0L, Long::sum);
                //Other solution
                //.mapToLong(BoardTestSuite::betweenDays)
                //.sum();
        LOGGER.info("The sum of the days of the task execution is: " + averageDaysSum);

        double averageDaysCount = project.getTaskLists().stream()
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .map(BoardTestSuite::betweenDays)
                .count();
        LOGGER.info("Number of items is: " + averageDaysCount);

        //Solution with average()
        double averageDays = project.getTaskLists().stream()
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .mapToLong(BoardTestSuite::betweenDays)
                .average().getAsDouble();

        double averageDaysDouble = round(averageDays, 2);
        LOGGER.info("Average number of days of task completion is: " + averageDaysDouble);

        //Then
        assertEquals(14.17, averageDaysDouble);

    }

    private static long betweenDays(LocalDate created) {
        return DAYS.between(created, LocalDate.now());
    }

    public static double round(double value, int places) throws IllegalArgumentException{
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }
}
