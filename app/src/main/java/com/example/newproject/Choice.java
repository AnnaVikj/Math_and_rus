package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.newproject.databinding.ActivityChoiceBinding;

public class Choice extends AppCompatActivity {
ActivityChoiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityChoiceBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.cat1.setOnClickListener(v -> {
            Intent intent = new Intent(this, DictationWords.class);
            intent.putExtra("cat1", "1");
            startActivity(intent);
        });
        binding.cat2.setOnClickListener(v -> {
            Intent intent = new Intent(this, DictationWords.class);
            intent.putExtra("cat1", "2");
            startActivity(intent);
        });
        binding.cat3.setOnClickListener(v -> {
            Intent intent = new Intent(this, DictationWords.class);
            intent.putExtra("cat1", "3");
            startActivity(intent);
        });
        binding.cat4.setOnClickListener(v -> {
            Intent intent = new Intent(this, DictationWords.class);
            intent.putExtra("cat1", "4");
            startActivity(intent);
        });
        binding.cat5.setOnClickListener(v -> {
            Intent intent = new Intent(this, DictationWords.class);
            intent.putExtra("cat1", "5");
            startActivity(intent);
        });
    }
}