package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import pl.droidsonroids.gif.GifImageView;

public class sleepIntro extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_intro);

        btn = findViewById(R.id.button5);
        GifImageView gifImageView = findViewById(R.id.gifImageView);
        gifImageView.setImageResource(R.drawable.sleep);

        btn.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(sleepIntro.this, thirdActivity.class);
            startActivity(intent);
        });
    }
}