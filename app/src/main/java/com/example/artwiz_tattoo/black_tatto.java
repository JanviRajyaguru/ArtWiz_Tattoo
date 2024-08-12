package com.example.artwiz_tattoo;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.artwiz_tattoo.databinding.ActivityBlackTattoBinding;


public class black_tatto extends AppCompatActivity {


    ActivityBlackTattoBinding binding;
    GridView grd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_black_tatto);
        binding = ActivityBlackTattoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        grd1=findViewById(R.id.grd1);

        String[] tattoName = {"b1","b2","b3","b4","b5","b6","b7","b8","b9","b10"};
        int[] tImages = {R.drawable.b7,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,
                R.drawable.b6,R.drawable.b7, R.drawable.b8,R.drawable.b9,R.drawable.b10};

        String[] tprice = {"100","200","300","400","500","600","700","800","900","300"};


        GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), tattoName, tImages,tprice);
        grd1.setAdapter(gridAdapter);

    }
}