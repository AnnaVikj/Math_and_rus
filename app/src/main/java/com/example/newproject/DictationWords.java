package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.newproject.data.WordBase;
import com.example.newproject.databinding.ActivityDictationWordsBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DictationWords extends AppCompatActivity {
    ActivityDictationWordsBinding binding;
    private WordBase roomdatabase;
    private List<Words> w1;
    private List<Words> w2;
    private List<Words> w3;
    private List<Words> w4;
    private List<Words> w5;

    private List<Words> gl;
    private int r = 5;
    private int y = 0;
    private Complet complet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String cat1 = getIntent().getStringExtra("cat1");
        gl = new ArrayList<>();
        w1 = new ArrayList<>();
        w2 = new ArrayList<>();
        w3 = new ArrayList<>();
        w4 = new ArrayList<>();
        w5 = new ArrayList<>();
        complet = new Complet();
        roomdatabase = Room.databaseBuilder(this, WordBase.class, "words.db")
                .allowMainThreadQueries()
                .build();
        binding = ActivityDictationWordsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        if (roomdatabase.WordsDao().getAll().size() == 0) {
            complet.complet(roomdatabase);
        }

        for (int i = 0; i < 14; i++) {
            w1.add(roomdatabase.WordsDao().getAll().get(i));
        }
        for (int i = 14; i < 28; i++) {
            w2.add(roomdatabase.WordsDao().getAll().get(i));
        }
        for (int i = 28; i < 42; i++) {
            w3.add(roomdatabase.WordsDao().getAll().get(i));
        }
        for (int i = 42; i < 56; i++) {
            w4.add(roomdatabase.WordsDao().getAll().get(i));
        }
        for (int i = 56; i < 70; i++) {
            w5.add(roomdatabase.WordsDao().getAll().get(i));
        }
        if(cat1.equals("1")){
            gl = w1;
        }else if(cat1.equals("2")){
            gl = w2;
        }else if(cat1.equals("3")){
            gl = w3;
        }else if(cat1.equals("4")){
            gl = w4;
        }else{
            gl = w5;
        }
        random_words();
    }



    private void random_words() {

        if(y == 14){
            y = 0;
        }
        binding.num.setText(y + 1 + " / " + gl.size());
        r = 5;
        binding.verdict.setText(" ");
        binding.one.setChecked(false);
        binding.two.setChecked(false);
        binding.three.setChecked(false);
        binding.four.setChecked(false);

            int q = (int) (Math.random() * 4);
            if (q == 0) {
                binding.one.setText(gl.get(y).getRight_word());
                binding.two.setText(gl.get(y).getWrong1());
                binding.three.setText(gl.get(y).getWrong2());
                binding.four.setText(gl.get(y).getWrong3());
            } else if (q == 1) {
                binding.one.setText(gl.get(y).getWrong1());
                binding.two.setText(gl.get(y).getRight_word());
                binding.three.setText(gl.get(y).getWrong2());
                binding.four.setText(gl.get(y).getWrong3());
            } else if (q == 2) {
                binding.one.setText(gl.get(y).getWrong2());
                binding.two.setText(gl.get(y).getWrong1());
                binding.three.setText(gl.get(y).getRight_word());
                binding.four.setText(gl.get(y).getWrong3());
            } else {
                binding.one.setText(gl.get(y).getWrong3());
                binding.two.setText(gl.get(y).getWrong1());
                binding.three.setText(gl.get(y).getWrong2());
                binding.four.setText(gl.get(y).getRight_word());
            }

            binding.answerButton.setOnClickListener(v -> {

                if (binding.one.isChecked()) {
                    r = 0;
                } else if (binding.two.isChecked()) {
                    r = 1;
                } else if (binding.three.isChecked()) {
                    r = 2;
                } else if (binding.four.isChecked()) {
                    r = 3;
                }
                if (r != 5) {
                    if (q == r) {
                        y ++;
                        binding.verdict.setText(getResources().getString(R.string.verno));
                        binding.verdict.setTextColor(Color.GREEN);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                random_words();
                            }
                        }, 1000);
                    } else {
                        binding.verdict.setTextColor(Color.RED);
                        binding.verdict.setText(getResources().getString(R.string.notright));
                    }
                } else {
                    Toast.makeText(this, getResources().getString(R.string.z), Toast.LENGTH_SHORT).show();
                }
            });

        }


    }
