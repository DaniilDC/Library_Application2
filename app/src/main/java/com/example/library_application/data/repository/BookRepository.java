package com.example.library_application.data.repository;

import com.example.library_application.R;
import com.example.library_application.data.datasource.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        books.add(new Book("Война и мир", R.drawable.purple_book));
        books.add(new Book("Горе от ума", R.drawable.purple_book));
        books.add(new Book("Идиот", R.drawable.purple_book));
    }

    public List<Book> getBooks() {
        return books;
    }
}
