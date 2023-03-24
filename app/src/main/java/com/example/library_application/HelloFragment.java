package com.example.library_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HelloFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hello, container, false);
        Button btn = view.findViewById(R.id.back);
        Button btn1 = view.findViewById(R.id.listViewButton);
        Button btn2 = view.findViewById(R.id.listRecycle);

//        TextView textView = view.findViewById(R.id.textView2);
//        String res = getArguments().getString("key1");
//        textView.setText(res);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_fragmentListView);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_fragmentRecycleView);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_startFragment);
            }
        });
        return view;
    }
}