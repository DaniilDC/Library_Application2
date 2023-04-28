package com.example.library_application.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.library_application.R;
import com.example.library_application.data.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookItemData {
    public LiveData<List<Book>> getBookItemList() {
        List<Book> bookItemList;
        bookItemList = new ArrayList<>();
        bookItemList.add(new Book("Три богатыря", R.drawable.purple_book));
        bookItemList.add(new Book("Самый самый", R.drawable.purple_book));
        bookItemList.add(new Book("Волк с Уолл Стрит", R.drawable.purple_book));
        bookItemList.add(new Book("Букварь", R.drawable.purple_book));
        MutableLiveData<List<Book>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(bookItemList);
        return mutableLiveData;
    }
}
