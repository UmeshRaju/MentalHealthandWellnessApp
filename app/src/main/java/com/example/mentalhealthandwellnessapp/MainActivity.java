package com.example.mentalhealthandwellnessapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView cardView = findViewById(R.id.cardView1);
        CardView cardView1 = findViewById(R.id.cardView2);
        CardView cardView2 = findViewById(R.id.cardView3);
        CardView cardView3 = findViewById(R.id.cardView4);

        // Add the animation to all CardViews
        fadeInAnimation(cardView);
        fadeInAnimation(cardView1);
        fadeInAnimation(cardView2);
        fadeInAnimation(cardView3);
        


        cardView.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, breatheIntro.class);
            startActivity(intent);
        });
        cardView1.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, sleepIntro.class);
            startActivity(intent);
        });
        cardView2.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, moodIntro.class);
            startActivity(intent);
        });
        cardView3.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, meditateIntro.class);
            startActivity(intent);
        });

        Intent serviceIntent = new Intent(this, ActivityTrackingService.class);
        startService(serviceIntent);

        Intent serviceIntent1 = new Intent(this, ActivityTrackingService.class);
        stopService(serviceIntent1);


    }

    private void fadeInAnimation(CardView cardView) {

        ObjectAnimator rotate = ObjectAnimator.ofFloat(cardView, "rotation", 0f, 360f);
        rotate.setDuration(2000); // Set the duration of the animation in milliseconds
        rotate.setInterpolator(new AccelerateDecelerateInterpolator()); // Optional: Set an interpolator for smooth animation

        // Start the animation
        rotate.start();
    }

    AirplaneModeChangeReceiver airplaneModeChangeReceiver = new AirplaneModeChangeReceiver();
    

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChangeReceiver, filter);
    }

    private void registerReceiver(AirplaneModeChangeReceiver airplaneModeChangeReceiver, IntentFilter filter) {
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModeChangeReceiver);
    }

    private void unregisterReceiver(AirplaneModeChangeReceiver airplaneModeChangeReceiver) {
    }

}