package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.example.newproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        binding.count.setOnClickListener(view -> {
            Intent intent = new Intent(this, Maths.class);
            intent.putExtra("Maths", "Maths_for");
            startActivity(intent);
        });

        binding.words.setOnClickListener(view -> {
            Intent intent = new Intent(this, DictationWords.class);
            intent.putExtra("Words", "Dictonary_words");
            startActivity(intent);
        });
    }


}