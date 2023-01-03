package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTest {

    @DisplayName("Test: probablyIWillThrowException")
    @Test
    void probablyIWillThrowException(){
        // given
        SecondChallenge obj = new SecondChallenge();
        // when & then
        assertAll(
            () -> assertDoesNotThrow(() -> obj.probablyIWillThrowException(1.0, 2.0)),
            () -> assertThrows(Exception.class, () -> obj.probablyIWillThrowException(1.0, 1.5)),
            () -> assertThrows(Exception.class, () -> obj.probablyIWillThrowException(2.0, 2.0)),
            () -> assertThrows(Exception.class, () -> obj.probablyIWillThrowException(0.0, 2.0))
        );
    }
}