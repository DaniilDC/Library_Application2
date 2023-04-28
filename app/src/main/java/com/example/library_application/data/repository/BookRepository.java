package com.example.library_application.data.repository;

import androidx.lifecycle.LiveData;

import com.example.library_application.R;
import com.example.library_application.data.datasource.BookItemData;
import com.example.library_application.data.models.Book;
import com.example.library_application.data.protocols.BookProtocol;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements BookProtocol {
    private final BookItemData getBookItemList = new BookItemData();
    @Override
    public LiveData<List<Book>> getBookItemList() {
        return getBookItemList.getBookItemList();
    }
}
