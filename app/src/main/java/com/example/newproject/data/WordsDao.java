package com.example.newproject.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.newproject.Words;

import java.util.List;

@Dao
public interface WordsDao {

    @Query("SELECT * FROM words")
    List<Words> getAll();

    @Insert
    void insertAll(Words... words);

    @Update
    void update(Words words);

    @Delete
    void delete(Words words);
}
