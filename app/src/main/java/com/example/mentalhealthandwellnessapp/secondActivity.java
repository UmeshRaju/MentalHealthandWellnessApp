package com.example.mentalhealthandwellnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class secondActivity extends AppCompatActivity {

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        BlankFragment Fragment = new BlankFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction;
        transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, Fragment,"frag");
        transaction.commit();
    }
}