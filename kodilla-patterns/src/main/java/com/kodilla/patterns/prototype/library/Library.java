package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype<Library> {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedBoard = super.clone();
        clonedBoard.books = new HashSet<>();
        for (Book theList : books) {
            Book clonedBooks = new Book(theList.getTitle(), theList.getAuthor(), theList.getPublicationDate());
            clonedBoard.books.add(clonedBooks);
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        return "Library {" +
                "name = '" + name + '\'' +
                ", books = " + books +
                '}';
    }
}
