package com.kodilla.testing.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TestCalculateAdvStatistics{

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
        System.out.println("\nTest TestCalculateAdvStatistics" +
                "begin!");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test TestCalculateAdvStatistics "
                + "end!\n");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    private List<String> generateListOfNUsers(int users) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= users; n++) {
            CalculateAdvStatistics theUser = new CalculateAdvStatistics(resultList, 0 + n, 0 + n, 100 + n);;
            resultList.add(String.valueOf(theUser));
        }
        return resultList;
    }

    @Mock
    private Statistics statisticsMock;

    @DisplayName("Name of test: TestCalculateAdvStatistics")
    @Test
    void testCalculateAdvStatisticsPostsCount0() {
        //Correct solution!

        //Given
        //Mt: argument 'statistics' is not need!
        //CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        CalculateAdvStatistics calculate = new CalculateAdvStatistics();
        List<String> usersNames = new ArrayList<>();
        //Not need
        //CalculateAdvStatistics testCount = new CalculateAdvStatistics(usersNames,1, 0, 100);

        //When
        //Mt: correction
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        calculate.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, calculate.getAverageCommentsCountPerPost());
        assertEquals(0, calculate.getAveragePostsCountPerUser());
        assertEquals(0, calculate.getAverageCommentsCountPerUser());

        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsPostsCount1000() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics();
        List<String> usersNames = new ArrayList<>();
        CalculateAdvStatistics user1 = new CalculateAdvStatistics(usersNames,  0, 0, 0);
        usersNames.add(String.valueOf(user1));

        //When
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList(usersNames.get(0)));

        calculate.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(1, calculate.getAverageCommentsCountPerPost());
        assertEquals(1000, calculate.getAveragePostsCountPerUser());
        assertEquals(1000, calculate.getAverageCommentsCountPerUser());
        //assertEquals(1000, testCount.postsCount());
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsCommentsCount1000() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics();
        List<String> usersNames = new ArrayList<>();
        CalculateAdvStatistics testCount = new CalculateAdvStatistics(usersNames, 1, 1000, 0);

        //When
        calculate.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, testCount.commentsCount());
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsFewerCommentsThanPosts() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics();
        List<String> usersNames = new ArrayList<>();
        CalculateAdvStatistics testCount = new CalculateAdvStatistics(usersNames, 1, 10, 9);
        int post = testCount.postsCount();
        int comment = testCount.commentsCount();
        int result = 0;
        if(comment < post) {
            result = 1;
        }

        //When
        calculate.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(1, result);
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsFewerPostThanComments() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics();
        List<String> usersNames = new ArrayList<>();
        CalculateAdvStatistics testCount = new CalculateAdvStatistics(usersNames,1, 10, 11);
        int post = testCount.postsCount();
        int comment = testCount.commentsCount();
        int result = 0;
        if(comment > post) {
            result = 1;
        }

        //When
        calculate.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(1, result);
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsUsers0Count() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics();

        List<String> listOfUsers = new ArrayList<>();
        CalculateAdvStatistics user1 = new CalculateAdvStatistics(listOfUsers,1, 1000, 0);
        CalculateAdvStatistics user2 = new CalculateAdvStatistics(listOfUsers, 2, 1000, 0);
        listOfUsers.add(String.valueOf(user1));
        listOfUsers.add(String.valueOf(user2));

        //When
        int usersCount = listOfUsers.size();
        calculate.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(2, usersCount);
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsUsers100Count() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics();
        List<String> resultListOf100Users = generateListOfNUsers(100);

        //When
        int usersCount = resultListOf100Users.size();
        calculate.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, usersCount);
        calculate.showStatistics();
    }
}
