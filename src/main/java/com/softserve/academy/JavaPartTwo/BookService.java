package com.softserve.academy.JavaPartTwo;

import java.util.ArrayList;
import java.util.Collections;

public class BookService {

    public String OUTER_SEPARATOR = "=========================================================";
    public String INNER_SEPARATOR = "---------------------------------------------------------";

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Book> additionalBooks = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        books.add(new Book("The Secret History", "Donna Tartt", "Literary Fiction", 1992));
        books.add(new Book("Normal People", "Sally Rooney", "Literary Fiction", 2018));
        books.add(new Book("The Goldfinch", "Donna Tartt", "Literary Fiction", 2013));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", 1998));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Romance", 1813));
        books.add(new Book("People We Meet on Vacation", "Emily Henry", "Romance", 2021));
        return books;
    }

    public ArrayList<Book> getAdditionalBooks() {
        additionalBooks.add(new Book("Fahrenheit 451", "Ray Bradbury", "science-fiction", 1953 ));
        additionalBooks.add(new Book("Starship Troopers", "Robert A. Heinlein ", "science-fiction", 1959));
        return additionalBooks;
    }

    public ArrayList<String> getListOfAuthors() {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Book authors: ");
        System.out.println();
        ArrayList result = new ArrayList();
        for (Book book : books) {
            System.out.println(book.getAuthor());
            result.add(book.getAuthor());
        }
        System.out.println(OUTER_SEPARATOR);
        return result;
    }

    public ArrayList<String> getAuthorsByGenre(String genre) {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Authors by genre - " + genre + " :");
        System.out.println(INNER_SEPARATOR);
        ArrayList result = new ArrayList();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                System.out.println(book.getAuthor());
                result.add(book.getAuthor());
            }
        }
        System.out.println(OUTER_SEPARATOR);
        return result;
    }

    public ArrayList<String> getAuthorsByPublicationYear(int year) {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Authors by Publication Year - " + year + " :");
        System.out.println(INNER_SEPARATOR);
        ArrayList result = new ArrayList();
        for (Book book : books) {
            if (book.getYear() == year) {
                System.out.println(book.getAuthor());
                result.add(book.getAuthor());
            }
        }
        System.out.println(OUTER_SEPARATOR);
        return result;
    }

    public ArrayList<String> getBookByAuthor(String author) {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Books by Author - " + author + " :");
        System.out.println(INNER_SEPARATOR);
        ArrayList result = new ArrayList();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book.getTitle());
                result.add(book.getTitle());
            }
        }
        System.out.println(OUTER_SEPARATOR);
        return result;
    }

    public ArrayList<String> getBookByPublicationYear(int year) {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Books by Publication year - " +  year + " :");
        System.out.println(INNER_SEPARATOR);
        ArrayList result = new ArrayList();
        for (Book book : books) {
            if (book.getYear() == year) {
                System.out.println(book.getTitle());
                result.add(book.getTitle());
            }
        }
        System.out.println(OUTER_SEPARATOR);
        return result;
    }

    public ArrayList<String> getBooksByGenre(String genre) {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Books by genre - " + genre + " :");
        System.out.println(INNER_SEPARATOR);
        ArrayList result = new ArrayList();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                System.out.println(book.getTitle());
                result.add(book.getTitle());
            }
        }
        System.out.println(OUTER_SEPARATOR);
        return result;
    }

    public void deleteBookByAuthor(String author) {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Delete books by author - " + author + " :");
        System.out.println(INNER_SEPARATOR);
        Book bookToDelete = null;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                bookToDelete = book;
                System.out.println("Deleted book by author - " + author);
            }
        }
        books.remove(bookToDelete);

    }

    public ArrayList<Book> sortCollectionByCriterion() {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Sort books by year : ");
        System.out.println(INNER_SEPARATOR);
        Collections.sort(books, (o1, o2) -> o1.getYear() - o2.getYear());
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println(OUTER_SEPARATOR);
        return books;
    }

    public ArrayList<Book> mergeBookCollections() {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Merged collection");
        books.addAll(additionalBooks);
        ArrayList result = new ArrayList();
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println(OUTER_SEPARATOR);
        return books;
    }

    public ArrayList<Book> getSubCollectionByGenre(String genre) {
        System.out.println(OUTER_SEPARATOR);
        System.out.println("Sub collection by genre - " + genre + ":");
        System.out.println(INNER_SEPARATOR);
        ArrayList<Book> subCollection = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                subCollection.add(book);
            }
        }
        for (Book book : subCollection) {
            System.out.println(book);
        }
        System.out.println(OUTER_SEPARATOR);
        return subCollection;
    }
}
