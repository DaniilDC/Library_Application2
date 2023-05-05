package com.example.library_application.ui.fragments;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.library_application.R;
import com.example.library_application.data.models.Book;
import com.example.library_application.ui.stateholder.adapter.BookAdapterRV;
import com.example.library_application.ui.stateholder.viewmodel.BookViewModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;


public class FragmentRecycleView extends Fragment {
    private BookViewModel bookViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView bookList = view.findViewById(R.id.recyclerView);

        String fileName = "m.txt";
        String fileContent = "Some data";
        try {
            File file_book = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
            FileOutputStream fos = new FileOutputStream(file_book);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContent);
            writer.close();
            fos.close();
            Toast.makeText(getContext(), "Файл создан", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        SharedPreferences sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        String chosen_book = sharedPreferences.getString(fileName, "");

        final BookAdapterRV bookAdapterRV1 = new BookAdapterRV(new BookAdapterRV.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                Bundle bundle = new Bundle();
                bundle.putString("title", book.getName());
                bundle.putInt("imageUrl", book.getFlagResource());
                Navigation.findNavController(getView()).
                        navigate(R.id.action_fragmentRecycleView_to_bookDescriptionFragment, bundle);
                SharedPreferences sharedWrite =
                        requireActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedWrite.edit();
                editor.putString(fileName, book.getName());
                editor.apply();

            }
        });
        bookList.setAdapter(bookAdapterRV1);
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getAllNotes().observe(requireActivity(), new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                bookAdapterRV1.setNotes(books);
            }
        });
        Button button = view.findViewById(R.id.RecycleToHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentRecycleView_to_helloFragment);
            }
        });
    }
}