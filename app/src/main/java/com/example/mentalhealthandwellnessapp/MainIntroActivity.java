package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainIntroActivity extends AppCompatActivity {
    Button btn;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intro);
        btn = findViewById(R.id.button3);
        btn1 = findViewById(R.id.button8);
        btn.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainIntroActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btn1.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainIntroActivity.this, contentProviders.class);
            startActivity(intent);
        });


    }
}