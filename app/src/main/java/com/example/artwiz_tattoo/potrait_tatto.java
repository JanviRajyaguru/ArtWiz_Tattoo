package com.example.artwiz_tattoo;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.artwiz_tattoo.databinding.ActivityPotraitTattoBinding;

public class potrait_tatto extends AppCompatActivity {

    ActivityPotraitTattoBinding binding;
    GridView grd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_potrait_tatto);

        binding = ActivityPotraitTattoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        grd1=findViewById(R.id.grd1);

        String[] tattoName = {"c1","c2","c3","c4", "c5","c6","c7","c8","c9","c10"};
        int[] tImages = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,
                R.drawable.p6,R.drawable.p7, R.drawable.p8,R.drawable.p9,R.drawable.p10};

        String[] tprice = {"100","200","300","400","500","600","700","800","900","300"};

        GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), tattoName, tImages,tprice);
        grd1.setAdapter(gridAdapter);
    }
}