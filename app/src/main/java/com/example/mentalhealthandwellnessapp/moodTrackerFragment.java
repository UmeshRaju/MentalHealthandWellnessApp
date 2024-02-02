package com.example.mentalhealthandwellnessapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class moodTrackerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mood_tracker, container, false);
        EditText moodEditText = view.findViewById(R.id.editTextText);
        Button submitButton = view.findViewById(R.id.button2);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capture the user's mood and send it directly to the activity
                String userMood = moodEditText.getText().toString();
                MoodListner moodListner = (MoodListner) getActivity();
                assert moodListner != null;
                moodListner.onMoodSelected(userMood);
            }
        });
        return view;
    }
}