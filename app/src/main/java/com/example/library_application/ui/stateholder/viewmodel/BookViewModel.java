package com.example.library_application.ui.stateholder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.library_application.data.datasource.Book;
import com.example.library_application.data.repository.BookRepository;

import java.util.List;

public class BookViewModel extends ViewModel {
    private MutableLiveData<List<Book>> bookItemListLiveData;
    public BookViewModel()
    {
        bookItemListLiveData = new MutableLiveData<>();
        BookRepository bookRepository = new BookRepository();
        bookItemListLiveData.setValue(bookRepository.getBooks());
    }

    public LiveData<List<Book>> getLiveData() {
        return bookItemListLiveData;
    }
}
