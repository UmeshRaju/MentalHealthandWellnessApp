package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import pl.droidsonroids.gif.GifImageView;

public class moodIntro extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_intro);
        btn = findViewById(R.id.button7);
        GifImageView gifImageView = findViewById(R.id.gifImageView);
        gifImageView.setImageResource(R.drawable.moodtracker);

        btn.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(moodIntro.this, moodTracker.class);
            startActivity(intent);
        });

    }
}