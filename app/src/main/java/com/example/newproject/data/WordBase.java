package com.example.newproject.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.newproject.Words;

@Database(entities = {Words.class}, version = 1)
public abstract class WordBase extends RoomDatabase {
    public abstract WordsDao WordsDao();
}
