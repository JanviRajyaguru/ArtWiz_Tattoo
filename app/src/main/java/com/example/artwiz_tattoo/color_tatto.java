package com.example.artwiz_tattoo;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.artwiz_tattoo.databinding.ActivityColorTattoBinding;

public class color_tatto extends AppCompatActivity {

    ActivityColorTattoBinding binding;
    GridView grd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_color_tatto);

        binding = ActivityColorTattoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        grd1=findViewById(R.id.grd1);

        String[] tattoName = {"c1","c2","c3","c4", "c5","c6","c7","c8","c9","c10"};
        int[] tImages = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                R.drawable.c6,R.drawable.c7, R.drawable.c8,R.drawable.c9,R.drawable.c10};

        String[] tprice = {"100","200","300","400","500","600","700","800","900","300"};

        GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), tattoName, tImages,tprice);
        grd1.setAdapter(gridAdapter);


    }
}