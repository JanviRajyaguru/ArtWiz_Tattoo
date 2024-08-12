package com.example.artwiz_tattoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    ImageButton black, color, potrait;
    ImageView home,profile,feedback,artist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        black = findViewById(R.id.black_tattoo);
        color = findViewById(R.id.color_tattoo);
        potrait = findViewById(R.id.potrait_tattoo);

        home = findViewById(R.id.home);
        profile = findViewById(R.id.profile);
        feedback = findViewById(R.id.feedback);
        artist = findViewById(R.id.artist);


        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, black_tatto.class);
                startActivity(i);
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, color_tatto.class);
                startActivity(i);
            }
        });

        potrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, potrait_tatto.class);
                startActivity(i);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, user_profile.class);
                startActivity(i);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, feedback_page.class);
                startActivity(i);
            }
        });
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, artist_portfolio.class);
                startActivity(i);
            }
        });
    }


}