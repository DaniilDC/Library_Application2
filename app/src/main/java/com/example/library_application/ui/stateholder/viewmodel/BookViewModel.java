package com.example.library_application.ui.stateholder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.library_application.data.models.Book;
import com.example.library_application.data.repository.BookRepository;

import java.util.List;

public class BookViewModel extends AndroidViewModel {
    private BookRepository repository;
    private LiveData<List<Book>> allNotes;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(Book note) {
        repository.insert(note);
    }

    public void update(Book note) {
        repository.update(note);
    }

    public void delete(Book note) {
        repository.delete(note);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Book>> getAllNotes() {
        return allNotes;
    }
}
