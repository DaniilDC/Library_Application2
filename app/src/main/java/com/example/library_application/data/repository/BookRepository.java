package com.example.library_application.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.library_application.data.datasource.BookDatabase;
import com.example.library_application.data.models.Book;
import com.example.library_application.data.protocols.BookProtocol;
import com.example.library_application.data.protocols.NoteDao;

import java.util.List;

public class BookRepository{
    private NoteDao noteDao;
    private LiveData<List<Book>> allNotes;

    public BookRepository(Application application) {
        BookDatabase database = BookDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Book book) {
        new InsertNoteAsyncTask(noteDao).execute(book);
    }

    public void update(Book book) {
        new UpdateNoteAsyncTask(noteDao).execute(book);
    }

    public void delete(Book book) {
        new DeleteNoteAsyncTask(noteDao).execute(book);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<Book>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Book, Void, Void> {
        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Book... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Book, Void, Void> {
        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Book... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Book, Void, Void> {
        private NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Book... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private DeleteAllNotesAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}
