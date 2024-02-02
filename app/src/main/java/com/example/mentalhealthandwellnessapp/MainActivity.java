package com.example.mentalhealthandwellnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.Button;

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
       /* button = (Button) findViewById(R.id.button1);*/
       /* bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.progress:
                        // Start Home activity
                        Intent firstintent = new Intent(MainActivity.this, secondActivity.class);
                        startActivity(firstintent);
                        return true;
                        break;
                    case R.id.profile:
                        // Start Search activity
                        Intent intent = new Intent(MainActivity.this, test.class);
                        startActivity(intent);
                        return true;
                        break;
                    // Handle other items...
                    default:
                        return false;
                        break;
                }
            }
        });
       */
        cardView.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, secondActivity.class);
            startActivity(intent);
        });
        cardView1.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, thirdActivity.class);
            startActivity(intent);
        });
        cardView2.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, moodTracker.class);
            startActivity(intent);
        });
        cardView3.setOnClickListener(v -> {
            // Launch the second activity when the card is clicked
            Intent intent = new Intent(MainActivity.this, meditatie.class);
            startActivity(intent);
        });
        /*
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,secondActivity.class);
            startActivity(intent);

        });*/
    }

}