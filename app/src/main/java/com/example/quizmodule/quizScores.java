package com.example.quizmodule;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class quizScores {
    @PrimaryKey
    public int id;
    public String username;
    public int score;
  //  private String quizType;

}
