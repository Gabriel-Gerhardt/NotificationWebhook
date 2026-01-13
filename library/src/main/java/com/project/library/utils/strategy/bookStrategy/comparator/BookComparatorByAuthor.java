package com.project.library.utils.strategy.bookStrategy.comparator;

import com.project.library.entities.Book;

import java.util.Comparator;

public class BookComparatorByAuthor implements Comparator<Book> {

    @Override
    public int compare (Book book, Book book2) {
        return book.getAuthor().getName().compareTo(book2.getAuthor().getName());
    }
}
