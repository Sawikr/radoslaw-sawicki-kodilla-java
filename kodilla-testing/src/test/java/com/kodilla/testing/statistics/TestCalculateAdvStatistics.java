package com.kodilla.testing.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class TestCalculateAdvStatistics {

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
            Statistics theUser = new CalculateAdvStatistics(1 + n, 0 + n, 100 + n);;
            resultList.add(String.valueOf(theUser));
        }
        return resultList;
    }

    @Mock
    private Statistics statisticsMock;

    @DisplayName("Name of test: TestCalculateAdvStatistics")
    @Test
    void testCalculateAdvStatisticsPostsCount0() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        Statistics testCount = new CalculateAdvStatistics(usersNames,1, 0, 100);

        //When
        calculate.calculateAdvStatistics(testCount);

        //Then
        assertEquals(0, calculate.postsCount());
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsPostsCount1000() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        Statistics testCount = new CalculateAdvStatistics(usersNames,  1, 1000, 100);

        //When
        calculate.calculateAdvStatistics(testCount);

        //Then
        assertEquals(1000, calculate.postsCount());
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsCommentsCount1000() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        Statistics testCount = new CalculateAdvStatistics(usersNames, 1, 1000, 0);

        //When
        calculate.calculateAdvStatistics(testCount);

        //Then
        assertEquals(0, calculate.commentsCount());
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsFewerCommentsThanPosts() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        Statistics testCount = new CalculateAdvStatistics(usersNames, 1, 10, 9);
        int post = testCount.postsCount();
        int comment = testCount.commentsCount();
        int result = 0;
        if(comment < post) {
            result = 1;
        }

        //When
        calculate.calculateAdvStatistics(testCount);

        //Then
        Assertions.assertEquals(1, result);
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsFewerPostThanComments() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        Statistics testCount = new CalculateAdvStatistics(usersNames,1, 10, 11);
        int post = testCount.postsCount();
        int comment = testCount.commentsCount();
        int result = 0;
        if(comment > post) {
            result = 1;
        }

        //When
        calculate.calculateAdvStatistics(testCount);

        //Then
        Assertions.assertEquals(1, result);
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsUsers0Count() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);

        List<String> listOfUsers = new ArrayList<>();
        Statistics user1 = new CalculateAdvStatistics(1, 1000, 0);
        Statistics user2 = new CalculateAdvStatistics(2, 1000, 0);
        listOfUsers.add(String.valueOf(user1));
        listOfUsers.add(String.valueOf(user2));
        Statistics list = new CalculateAdvStatistics(listOfUsers);

        //When
        int usersCount = listOfUsers.size();
        calculate.calculateAdvStatistics(list);

        //Then
        assertEquals(2, usersCount);
        calculate.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsUsers100Count() {
        //Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        List<String> resultListOf100Users = generateListOfNUsers(100);
        Statistics list = new CalculateAdvStatistics(resultListOf100Users);

        //When
        int usersCount = resultListOf100Users.size();
        calculate.calculateAdvStatistics(list);

        //Then
        assertEquals(100, usersCount);
        calculate.showStatistics();
    }
}
