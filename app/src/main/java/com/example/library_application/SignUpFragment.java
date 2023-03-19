package com.example.library_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SignUpFragment extends Fragment {
    private static final String TAG = "MyApp";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        TextView textView = view.findViewById(R.id.register2);
//        getParentFragmentManager().setFragmentResultListener("dataFrom1", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
//                String data = result.getString("df1");
//                EditText textView = view.findViewById(R.id.Email2);
//                textView.setText(data);
//            }
//        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr1 = getFragmentManager().beginTransaction();
                fr1.replace(R.id.fragmentContainerView, new HelloFragment());
                fr1.commit();
            }
        });
        return view;
    }
}