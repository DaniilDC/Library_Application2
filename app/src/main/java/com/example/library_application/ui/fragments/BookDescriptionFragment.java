package com.example.library_application.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.library_application.R;

public class BookDescriptionFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_IMAGE_URL = "imageUrl";
    private ImageView bookImage;
    private TextView bookTitle;

    public BookDescriptionFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_description, container, false);
        bookImage = view.findViewById(R.id.bookLogo);
        bookTitle = view.findViewById(R.id.bookTitle);
        Bundle args = getArguments();
        if (args != null) {
            String title = args.getString(ARG_TITLE);
            int imageUrl = args.getInt(ARG_IMAGE_URL);
            bookTitle.setText(title);
            Glide.with(this).load(imageUrl).into(bookImage);
        }

        return view;
    }
}