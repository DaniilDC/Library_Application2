package com.example.library_application.ui.stateholder.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library_application.R;
import com.example.library_application.data.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAdapterRV extends RecyclerView.Adapter<BookAdapterRV.ViewHolder> {
    private final OnBookClickListener onClickListener;
    private List<Book> notes = new ArrayList<>();
    public BookAdapterRV(OnBookClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public interface OnBookClickListener {
        void onBookClick(Book book);
    }

    @NonNull
    @Override
    public BookAdapterRV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookAdapterRV.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Book book = notes.get(position);
        holder.flagView.setImageResource(book.getFlagResource());
        holder.nameView.setText(book.getName());
        holder.itemView.setOnClickListener(v -> onClickListener.onBookClick(book));
    }

    @Override
    public int getItemCount() {
        return notes.size();
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
    public void setNotes(List<Book> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }
}
