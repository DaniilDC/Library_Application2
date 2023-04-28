package com.example.library_application.ui.stateholder.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library_application.R;
import com.example.library_application.data.models.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<Book> books;

    public BookAdapter(Context context, int resource, List<Book> books) {
        super(context, resource, books);
        this.books = books;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int i, View ConvertView, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View view = inflater.inflate(this.layout, viewGroup, false);

        ImageView flagView = view.findViewById(R.id.PurpleBook);
        TextView nameView = view.findViewById(R.id.name);

        Book book = books.get(i);

        flagView.setImageResource(book.getFlagResource());
        nameView.setText(book.getName());

        return view;
    }
}
