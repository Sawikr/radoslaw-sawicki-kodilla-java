package com.kodilla;

/**
 * Check class AppRecord to Java Record!
 * Looking for in kodilla-course
 */

class Book {

        private String author;
        private String title;
        private int year;

        public Book(String author, String title, int year) {
            this.author = author;
            this.title = title;
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Book book = (Book) o;

            if (year != book.year) return false;
            if (author != null ? !author.equals(book.author) : book.author != null) return false;
            return title != null ? title.equals(book.title) : book.title == null;
        }

        @Override
        public int hashCode() {
            int result = author != null ? author.hashCode() : 0;
            result = 31 * result + (title != null ? title.hashCode() : 0);
            result = 31 * result + year;
            return result;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", year=" + year +
                    '}';
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }
}

public class AppRecord {
    public static void main(String[] args) {

        /* //chang to record app!
        Book book = new Book("John Novak", "Algorithms and other nightmares", 2018);
        int year = book.getYear();
        System.out.println(book);
        System.out.println(year);
         */

        BookRecord book = new BookRecord("John Novak", "Algorithms and other nightmares", 2018);
        int year = book.year();//getter working!
        System.out.println(book);
        System.out.println(year);
    }
}
