package com.example.library_application.ui.stateholder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.library_application.data.datasource.BookItemData;
import com.example.library_application.data.models.Book;
import com.example.library_application.data.repository.BookRepository;

import java.util.List;

public class BookViewModel extends ViewModel {
    private final BookItemData getterBookItemList = new BookItemData();
    public LiveData<List<Book>> bookItemList = getterBookItemList.getBookItemList();
}
