package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private AndroidFragment androidFragment;
    private JavaFragment javaFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        androidFragment = new AndroidFragment();
        javaFragment = new JavaFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.right_layout, androidFragment);
        fragmentTransaction.commit();
        androidInfoPage();
        javaInfoPage();
    }

    private void javaInfoPage() {
        Button javaButton = findViewById(R.id.java_button);
        javaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.right_layout, javaFragment);
                fragmentTransaction.commit();
            }
        });
    }

    private void androidInfoPage() {
        Button androidButton = findViewById(R.id.android_button);
        androidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.right_layout, androidFragment);
                fragmentTransaction.commit();
            }
        });
    }
}