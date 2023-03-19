package com.example.library_application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapterRV extends RecyclerView.Adapter<BookAdapterRV.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Book> books;
    private final OnBookClickListener onClickListener;

    public BookAdapterRV(Context context, List<Book> books, OnBookClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.books = books;
        this.onClickListener = onClickListener;
    }
    interface OnBookClickListener {
        void onBookClick(Book book, int position);
    }

    @NonNull
    @Override
    public BookAdapterRV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookAdapterRV.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Book book = books.get(position);
        holder.flagView.setImageResource(book.getFlagResource());
        holder.nameView.setText(book.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onBookClick(book, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView;

        ViewHolder(View view) {
            super(view);
            flagView = view.findViewById(R.id.PurpleBook);
            nameView = view.findViewById(R.id.name);
        }
    }
}
