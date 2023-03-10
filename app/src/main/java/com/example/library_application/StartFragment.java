package com.example.library_application;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class StartFragment extends Fragment {
    private static final String TAG = "MyApp1";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(),"onCreate!",Toast.LENGTH_SHORT).show();
        Log.e(TAG, "OnCreate - StartFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start, container, false);
        Button btn = view.findViewById(R.id.login);

        TextView textView = view.findViewById(R.id.register);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EditText editText = view.findViewById(R.id.Email);
//                Bundle result = new Bundle();
//                result.putString("df1", editText.getText().toString());
//                SignUpFragment signUpFragment = new SignUpFragment();
//                signUpFragment.setArguments(result);
//                getFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, signUpFragment)
//                        .commit();
//                getParentFragmentManager().setFragmentResult("dataFrom1", result);
//                editText.setText("");

                FragmentTransaction fr1 = getFragmentManager().beginTransaction();
                fr1.replace(R.id.fragmentContainerView, new SignUpFragment());
                fr1.commit();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragmentContainerView, new HelloFragment());
                fr.commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "OnViewCreated - StartFragment");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.w(TAG, "OnViewStateRestored - StartFragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart - StartFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "OnResume - StartFragment");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "OnPause - StartFragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "OnStop - StartFragment");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "OnSavedInstanceState - StartFragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "OnDestroyView - StartFragment");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "OnDestroy - StartFragment");
    }
}