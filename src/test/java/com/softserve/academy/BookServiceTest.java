package com.softserve.academy;

import com.softserve.academy.JavaPartTwo.Book;
import com.softserve.academy.JavaPartTwo.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    public ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Book> additionalBooks = new ArrayList<>();
    BookService bookService = new BookService();

    @Before
    public void setup() {
        books = bookService.getBooks();
        additionalBooks = bookService.getAdditionalBooks();
    }

    @Test
    public void getListOfAuthorsTest() {
        Assertions.assertEquals(7, books.size());
    }

    @Test
    public void getAuthorsByGenreTest() {
        String genre = "Romance";
        ArrayList<String> result = bookService.getAuthorsByGenre(genre);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains("Jane Austen"));
        Assertions.assertTrue(result.contains("Emily Henry"));
        Assertions.assertFalse(result.contains("J.R.R. Tolkien"));
    }
    @Test
    public void getAuthorsByPublicationYear(){
        int year = 2018;
        ArrayList<String> result = bookService.getAuthorsByPublicationYear(year);
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains("Sally Rooney"));

    }
    @Test
    public void getBookByAuthor(){
        String author = "J.K. Rowling";
        ArrayList<String> result = bookService.getBookByAuthor(author);
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains("Harry Potter and the Chamber of Secrets"));
    }
    @Test
    public void getBookByPublicationYear(){
        int year = 1937;
        ArrayList<String> result = bookService.getBookByPublicationYear(year);
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains("The Hobbit"));
    }
    @Test
    public void getBooksByGenre(){
        String genre = "Fantasy";
        ArrayList<String> result = bookService.getBooksByGenre(genre);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains("The Hobbit"));
        Assertions.assertTrue(result.contains("Harry Potter and the Chamber of Secrets"));
    }
    @Test
    public void deleteBookByAuthor(){
        String author = "Donna Tartt";
        bookService.deleteBookByAuthor(author);
        Assertions.assertEquals(6, books.size());
        Assertions.assertFalse(books.contains("The Secret History"));
    }
    @Test
    public void sortCollectionByCriterion() {
        ArrayList<Book> result = bookService.sortCollectionByCriterion();
        bookService.sortCollectionByCriterion();
        Assertions.assertTrue(books.get(0).getYear() < books.get(1).getYear());
        Assertions.assertTrue(books.get(1).getYear() < books.get(2).getYear());
        Assertions.assertTrue(books.get(2).getYear() < books.get(3).getYear());
        Assertions.assertTrue(books.get(3).getYear() < books.get(4).getYear());
        Assertions.assertTrue(books.get(4).getYear() < books.get(5).getYear());
        Assertions.assertTrue(books.get(5).getYear() < books.get(6).getYear());
    }

    @Test
    public void mergeBookCollections(){
        ArrayList<Book> result = bookService.mergeBookCollections();
        Assertions.assertEquals(9, result.size());
    }
    @Test
    public void getSubCollectionByGenre(){
        String genre = "Romance";
        ArrayList<Book> result = bookService.getSubCollectionByGenre(genre);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.get(0).getTitle() == "Pride and Prejudice");
        Assertions.assertTrue(result.get(1).getTitle() == "People We Meet on Vacation");
    }
}



