package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.newproject.databinding.ActivityMathsBinding;

public class Maths extends AppCompatActivity {
ActivityMathsBinding binding;

int answer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMathsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        two_number();

    }

    private void two_number() {
        binding.input.getText().clear();


        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        int sign = (int) (Math.random() * 2);
        if (sign % 2 == 0){
            answer = a + b;
            binding.example.setText(a + " + " + b + "?");
        }else{

            if(a > b){
            answer = a - b;
            binding.example.setText(a + " - " + b + "?");
            }else{
            answer = b - a;
            binding.example.setText(b + " - " + a + "?");
            }
        }

        binding.answerButton.setOnClickListener(view -> {
            String input = binding.input.getText().toString();
            if(!input.isEmpty()) {
                if (String.valueOf(answer).equals(input)) {
                    binding.verdict.setText(getResources().getString(R.string.verno));
                    binding.verdict.setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            binding.verdict.setText("");
                            two_number();
                        }
                    }, 1000);
                } else {
                    binding.verdict.setTextColor(Color.RED);
                    binding.verdict.setText(getResources().getString(R.string.notright));
                }
            }else{
                Toast.makeText(this, getResources().getString(R.string.q), Toast.LENGTH_SHORT).show();
            }
        });

    }
}