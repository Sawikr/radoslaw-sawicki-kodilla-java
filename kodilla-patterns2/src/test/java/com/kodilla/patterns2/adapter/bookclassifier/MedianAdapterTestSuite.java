package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMedian() {
        //Given
        Set<Book> books = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            books.add(new Book("Author" + i, "title" + i, 1990 + i, "signature" + 1));
        }
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(books);

        //Then
        System.out.println(publicationYearMedian);
    }
}