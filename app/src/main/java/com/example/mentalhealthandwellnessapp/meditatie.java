package com.example.mentalhealthandwellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class meditatie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditatie);

        MeditateFragment1 frag = new MeditateFragment1();
        meditateFragement frag1 = new meditateFragement();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1Container, frag)
                .commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment2Container, frag1)
                .commit();
    }
}