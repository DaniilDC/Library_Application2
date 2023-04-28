package com.example.library_application.ui.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.library_application.R;
import com.example.library_application.data.models.Book;
import com.example.library_application.ui.stateholder.adapter.BookAdapterRV;
import com.example.library_application.ui.stateholder.viewmodel.BookViewModel;


public class FragmentRecycleView extends Fragment implements BookAdapterRV.OnBookClickListener{
    private BookAdapterRV bookAdapterRV;
    private BookViewModel bookViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookAdapterRV = new BookAdapterRV(bookViewModel.bookItemList, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view, container, false);
        Button button = view.findViewById(R.id.RecycleToHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentRecycleView_to_helloFragment);
            }
        });


        RecyclerView bookList = view.findViewById(R.id.recyclerView);
        bookList.setAdapter(bookAdapterRV);

        return view;
    }
    @Override
    public void onBookClick(Book book) {
        Bundle bundle = new Bundle();
        bundle.putString("title", book.getName());
        bundle.putInt("imageUrl", book.getFlagResource());
        Navigation.findNavController(getView()).navigate(R.id.action_fragmentRecycleView_to_bookDescriptionFragment, bundle);
    }

}