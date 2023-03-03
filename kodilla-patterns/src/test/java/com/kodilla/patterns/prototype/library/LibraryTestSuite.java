package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

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

    @DisplayName("Name of test: testGetBooks")
    @Test
    void testGetBooks() {
        //Given
        Book bookOne = new Book("Spring in Action", "Craig Walls", LocalDate.ofYearDay(2021, 21));
        Book bookTwo = new Book("Spring Boot in Action", "Craig Walls", LocalDate.ofYearDay(2020, 20));
        Library library = new Library("SpringBooks");

        //When
        library.books.add(bookOne);
        library.books.add(bookTwo);
        System.out.println(library);

        //Then
        assertFalse(library.books.isEmpty());
        assertEquals(2, library.books.size());
    }

    @DisplayName("Name of test: testGetBooksPrototypeShallowCopy")
    @Test
    void testGetBooksPrototypeShallowCopy() {
        //Given
        Book bookOne = new Book("Spring in Action", "Craig Walls", LocalDate.ofYearDay(2021, 21));
        Book bookTwo = new Book("Spring Boot in Action", "Craig Walls", LocalDate.ofYearDay(2020, 20));
        Library library = new Library("SpringBooks");
        library.books.add(bookOne);
        library.books.add(bookTwo);

        //When
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("SpringBooksCopy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(clonedLibrary);
        assert clonedLibrary != null;
        library.books.remove(bookTwo);
        System.out.println("Remove from 'SpringBooks' (shallow copy)\nThe number of books in the 'SpringBooksCopy' library " +
                "changes: \n" + clonedLibrary);

        //Then
        assert clonedLibrary != null;
        assertFalse(clonedLibrary.books.isEmpty());
        assertEquals(1, clonedLibrary.books.size());
    }

    @DisplayName("Name of test: testGetBooksPrototypeDeepCopy")
    @Test
    void testGetBooksPrototypeDeepCopy() {
        //Given
        Book bookOne = new Book("Spring in Action", "Craig Walls", LocalDate.ofYearDay(2021, 21));
        Book bookTwo = new Book("Spring Boot in Action", "Craig Walls", LocalDate.ofYearDay(2020, 20));
        Library library = new Library("SpringBooks");
        library.books.add(bookOne);
        library.books.add(bookTwo);

        //When
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.deepCopy();
            clonedLibrary.setName("SpringBooksCopy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(clonedLibrary);
        assert clonedLibrary != null;
        library.books.remove(bookTwo);
        System.out.println("Remove from 'SpringBooks' library (deep copy)\nThe number of books in the 'SpringBooksCopy' library " +
                "does not change: \n" + clonedLibrary);

        //Then
        assert clonedLibrary != null;
        assertFalse(clonedLibrary.books.isEmpty());
        assertEquals(2, clonedLibrary.books.size());
    }
}
