package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.newproject.data.WordBase;
import com.example.newproject.databinding.ActivityDictationWordsBinding;

import java.util.concurrent.atomic.AtomicInteger;

public class DictationWords extends AppCompatActivity {
ActivityDictationWordsBinding binding;
private WordBase roomdatabase;
private int r = 5;
private Complet complet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        complet = new Complet();
        roomdatabase = Room.databaseBuilder(this, WordBase.class, "roomwordbase").allowMainThreadQueries().build();
        binding = ActivityDictationWordsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        if(roomdatabase.WordsDao().getAll().size() == 0){
            complet.complet(roomdatabase);
        }

        random_words();
    }


    private void random_words() {

        r = 5;
        binding.verdict.setText(" ");
        binding.one.setChecked(false);
        binding.two.setChecked(false);
        binding.three.setChecked(false);
        binding.four.setChecked(false);

        int index = (int) (Math.random() * (roomdatabase.WordsDao().getAll().size()));
        int q = (int) (Math.random() * 4);

        if (q == 0) {
            binding.one.setText(roomdatabase.WordsDao().getAll().get(index).getRight_word());
            binding.two.setText(roomdatabase.WordsDao().getAll().get(index).getWrong1());
            binding.three.setText(roomdatabase.WordsDao().getAll().get(index).getWrong2());
            binding.four.setText(roomdatabase.WordsDao().getAll().get(index).getWrong3());
        } else if (q == 1) {
            binding.one.setText(roomdatabase.WordsDao().getAll().get(index).getWrong1());
            binding.two.setText(roomdatabase.WordsDao().getAll().get(index).getRight_word());
            binding.three.setText(roomdatabase.WordsDao().getAll().get(index).getWrong2());
            binding.four.setText(roomdatabase.WordsDao().getAll().get(index).getWrong3());
        } else if (q == 2) {
            binding.one.setText(roomdatabase.WordsDao().getAll().get(index).getWrong2());
            binding.two.setText(roomdatabase.WordsDao().getAll().get(index).getWrong1());
            binding.three.setText(roomdatabase.WordsDao().getAll().get(index).getRight_word());
            binding.four.setText(roomdatabase.WordsDao().getAll().get(index).getWrong3());
        } else {
            binding.one.setText(roomdatabase.WordsDao().getAll().get(index).getWrong3());
            binding.two.setText(roomdatabase.WordsDao().getAll().get(index).getWrong1());
            binding.three.setText(roomdatabase.WordsDao().getAll().get(index).getWrong2());
            binding.four.setText(roomdatabase.WordsDao().getAll().get(index).getRight_word());
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
                    binding.verdict.setText("Верно!");
                    binding.verdict.setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            random_words();
                        }
                    }, 1000);
                } else {
                    binding.verdict.setTextColor(Color.RED);
                    binding.verdict.setText("Неправильно! Попробуй снова");
                }
            }else{
                Toast.makeText(this, "Вы ничего не выбрали", Toast.LENGTH_SHORT).show();
            }
        });

    }


}