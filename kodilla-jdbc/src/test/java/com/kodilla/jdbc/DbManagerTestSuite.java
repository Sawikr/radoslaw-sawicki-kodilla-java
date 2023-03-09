package com.kodilla.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbManagerTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end!");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("Name of test: testSelectUsersAndPosts")
    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
			SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER
			FROM USERS_TWO U JOIN POSTS P ON U.ID = P.USER_ID
			GROUP BY P.USER_ID
			HAVING COUNT(*) > 1
			ORDER BY U.LASTNAME, U.FIRSTNAME
			""";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        System.out.println("The names of users who have published two or more posts:");
        while (rs.next()) {
            System.out.println(
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getInt("POSTS_NUMBER"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(2, counter);
    }
}
