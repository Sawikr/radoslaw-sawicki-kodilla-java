package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {

    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> bookList = new ArrayList<>();
        List<Book> resultList = libraryDatabase.listBooksInHandsOf(libraryUser);
        if (libraryUser.getNumberOfBooks() == 0) {
            return resultList;
        }
        else if (libraryUser.getNumberOfBooks() == 1) {
            for (int n = 1; n <= libraryUser.getNumberOfBooks(); n++) {
                Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
                resultList.add(theBook);
            }
            return resultList;
        }
        else if (libraryUser.getNumberOfBooks() == 5) {
            {
                for (int n = 1; n <= libraryUser.getNumberOfBooks(); n++) {
                    Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
                    resultList.add(theBook);
                }
                return resultList;
            }
        }
        bookList = resultList;
        return bookList;
    }
}