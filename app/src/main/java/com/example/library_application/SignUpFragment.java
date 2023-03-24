package com.example.library_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpFragment extends Fragment {
    private static final String TAG = "MyApp";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        TextView textView = view.findViewById(R.id.register2);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EditText editText = view.findViewById(R.id.Email2);
//                String email_name = editText.getText().toString();
//                Bundle result = new Bundle();
//                result.putString("key1", email_name);

                Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_helloFragment);
            }
        });
        return view;
    }
}