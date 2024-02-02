package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final EditText ageEditText = findViewById(R.id.ageEditText);
        final EditText sleepTimeEditText = findViewById(R.id.sleepTime);
        Button submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                int age = Integer.parseInt(ageEditText.getText().toString());
                int sleepTime = Integer.parseInt(sleepTimeEditText.getText().toString());

                // Load the fragment
                fragment2 displayFragment = fragment2.newInstance(age, sleepTime);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, displayFragment)
                        .commit();
            }
        });
    }
}