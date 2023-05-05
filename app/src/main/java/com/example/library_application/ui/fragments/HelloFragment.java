package com.example.library_application.ui.fragments;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.library_application.R;

import org.w3c.dom.Text;

public class HelloFragment extends Fragment {

    private static final String CHANNEL_ID = "ChannelID";
    boolean permission_external_storage = false;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_EXTERNAL_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hello, container, false);
        Button btn = view.findViewById(R.id.back);
        Button btn1 = view.findViewById(R.id.listViewButton);
        Button btn2 = view.findViewById(R.id.listRecycle);
        Button NotBtn = view.findViewById(R.id.Notification);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_fragmentListView);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!permission_external_storage)
//                    requestPermissionExtStorage();
//                else
                    Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_fragmentRecycleView);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_startFragment);
            }
        });

        NotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                showNotification();
            }
        });
        return view;
    }
    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "book",
                    NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager notificationManager =
                    (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void showNotification()
    {
        Notification notification = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.purple_book)
                .setContentText("Книга")
                .setContentTitle("Добавлено")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
    private void requestPermissionExtStorage() {
        if (ContextCompat.checkSelfPermission(requireContext(), PERMISSIONS_EXTERNAL_STORAGE[1]) == PackageManager.PERMISSION_GRANTED) {
            permission_external_storage = true;
            Toast.makeText(getContext(), "ExtStorage Permission Granted...", Toast.LENGTH_SHORT).show();
        }
        else {
            requestPermissionLauncherExtStorage.launch(PERMISSIONS_EXTERNAL_STORAGE[1]);
        }
    }
    private final ActivityResultLauncher<String> requestPermissionLauncherExtStorage = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    permission_external_storage = true;
                    requestPermissionExtStorage();
                }
                else {
                    permission_external_storage = false;
                }
            }
    );
}