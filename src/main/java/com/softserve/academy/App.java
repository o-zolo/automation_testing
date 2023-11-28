package com.softserve.academy;

import com.softserve.academy.JavaPartTwo.BookService;

/**
 * Hello world!
 *
 */
public class App {



    public static void main(String[] args) {
        BookService bookService = new BookService();
        bookService.getBooks();
        bookService.getListOfAuthors();
        //Call corresponding method form BookService here
    }
}
