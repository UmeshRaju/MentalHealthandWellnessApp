package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class breatheIntro extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe_intro);

        btn = findViewById(R.id.button4);
        GifImageView gifImageView = findViewById(R.id.gifImageView);
        gifImageView.setImageResource(R.drawable.breathexercise);

        btn.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(breatheIntro.this, secondActivity.class);
            startActivity(intent);
        });


    }
}