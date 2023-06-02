package com.example.newproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Words {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private long id;
    @ColumnInfo(name="right_word")
    private String right_word;
    @ColumnInfo(name="wrong1")
    private String wrong1;
    @ColumnInfo(name="wrong2")
    private String wrong2;
    @ColumnInfo(name="wrong3")
    private String wrong3;

    public Words(String right_word, String wrong1, String wrong2, String wrong3) {
        this.right_word = right_word;
        this.wrong1 = wrong1;
        this.wrong2 = wrong2;
        this.wrong3 = wrong3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRight_word() {
        return right_word;
    }

    public void setRight_word(String right_word) {
        this.right_word = right_word;
    }

    public String getWrong1() {
        return wrong1;
    }

    public void setWrong1(String wrong1) {
        this.wrong1 = wrong1;
    }

    public String getWrong2() {
        return wrong2;
    }

    public void setWrong2(String wrong2) {
        this.wrong2 = wrong2;
    }

    public String getWrong3() {
        return wrong3;
    }

    public void setWrong3(String wrong3) {
        this.wrong3 = wrong3;
    }
}
