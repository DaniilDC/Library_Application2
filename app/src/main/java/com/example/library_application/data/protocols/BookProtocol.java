package com.example.library_application.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.library_application.data.models.Book;

import java.util.List;

public interface BookProtocol {
    LiveData<List<Book>> getBookItemList();
}
