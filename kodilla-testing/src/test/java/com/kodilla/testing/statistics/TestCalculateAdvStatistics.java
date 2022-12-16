package com.kodilla.testing.statistics;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class TestCalculateAdvStatistics {

    @Mock
    private Statistics statisticsMock;

    @Test
    void testCalculateAdvStatisticsPostCount() {

        // Given
        CalculateAdvStatistics calculate = new CalculateAdvStatistics(statisticsMock);
        List<String> resultListOfUser = new ArrayList<>();

        CalculateAdvStatistics user1 = new CalculateAdvStatistics("Radek Sawicki", 100, 100);
        CalculateAdvStatistics user2 = new CalculateAdvStatistics("Agnieszka Sawicka", 200, 200);
        CalculateAdvStatistics user3 = new CalculateAdvStatistics("Kasjan Sawicki", 50, 50);
        resultListOfUser.add(String.valueOf(user1));
        resultListOfUser.add(String.valueOf(user2));
        resultListOfUser.add(String.valueOf(user3));

        when(statisticsMock.postsCount()).thenReturn(user1.postCount());

        // When
        //CalculateAdvStatistics testCount = calculate.calculateAdvStatistics();//nie wiem jak tu zrobić test???

        // Then
        //assertEquals(0, testCount);

    }
}
