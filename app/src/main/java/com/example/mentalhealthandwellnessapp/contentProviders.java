package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class contentProviders extends AppCompatActivity  {


    private EditText TextName;
    private EditText TextAge;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_providers);

        TextName = findViewById(R.id.editTextName);
        TextAge = findViewById(R.id.editTextAge);
        Button buttonSaveProfile = findViewById(R.id.saveProfileButton);

        buttonSaveProfile.setOnClickListener(v -> saveUserProfile());
    }



    private void saveUserProfile() {
        String name = TextName.getText().toString();
        String ageString = TextAge.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(ageString)) {
            int age = Integer.parseInt(ageString);

            // Create ContentValues to insert into Content Provider
            ContentValues values = new ContentValues();
            values.put(UserProfileContract.UserProfileEntry.COLUMN_NAME, name);
            values.put(UserProfileContract.UserProfileEntry.COLUMN_AGE, age);

            // Insert data into the Content Provider
            Uri uri = getContentResolver().insert(UserProfileContract.UserProfileEntry.CONTENT_URI, values);

            if (uri != null) {
                Toast.makeText(this, "Profile saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to save profile", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter name and age", Toast.LENGTH_SHORT).show();
        }
    }

}