package com.example.library_application.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.library_application.R;
import com.example.library_application.data.models.Book;
import com.example.library_application.ui.stateholder.adapter.BookAdapter;

import java.util.ArrayList;

public class FragmentListView extends Fragment {
    private static final String TAG = "ListView";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        Button button = view.findViewById(R.id.ListToHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentListView_to_helloFragment);
            }
        });

        ArrayList<Book> books = new ArrayList<Book>();
        String[] all_books = getResources().getStringArray(R.array.Book_names);
        for (String brand : all_books) {
            books.add(new Book(brand, R.drawable.purple_book));
        }
        ListView bookList = view.findViewById(R.id.listViewBooks);
        BookAdapter bookAdapter = new BookAdapter(getContext(), R.layout.item, books);
        bookList.setAdapter(bookAdapter);

        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = all_books[position];
                Log.i(TAG, "You clicked on " + selectedItem);
                Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}