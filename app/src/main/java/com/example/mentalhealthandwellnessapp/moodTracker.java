package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class moodTracker extends AppCompatActivity implements MoodListner {


    public TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);

        message = findViewById(R.id.textview14);

        // Load the MoodFragment into the fragmentContainer
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout2, new moodTrackerFragment())
                .commit();
    }

    @Override
    public void onMoodSelected(String userMood) {

        if (userMood.equalsIgnoreCase("sad")) {
            // Display a message in the activity based on the mood
            message.setText(R.string.mood1);
        }
        else {
            message.setText(R.string.mood2);
        }
    }

}