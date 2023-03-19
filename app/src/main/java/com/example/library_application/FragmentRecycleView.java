package com.example.library_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentRecycleView extends Fragment {
    private static final String TAG = "RecyleView";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view, container, false);
        Button button = view.findViewById(R.id.RecycleToHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragmentContainerView, new HelloFragment());
                fr.commit();
            }
        });

        ArrayList<Book> books = new ArrayList<Book>();
        String[] all_books = getResources().getStringArray(R.array.Book_names);
        for (String book : all_books) {
            books.add(new Book(book, R.drawable.purple_book));
        }
        RecyclerView bookList = view.findViewById(R.id.recyclerView);
        BookAdapterRV.OnBookClickListener bookClickListener = new BookAdapterRV.OnBookClickListener() {
            @Override
            public void onBookClick(Book book, int position) {
                String selectedItem = all_books[position];
                Log.i(TAG, "You clicked on " + selectedItem);
                Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        };
        BookAdapterRV bookAdapterRV = new BookAdapterRV(getContext(), books, bookClickListener);
        bookList.setAdapter(bookAdapterRV);

        return view;
    }
}