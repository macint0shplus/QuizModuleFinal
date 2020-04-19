package com.example.quizmodule;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// This object is an entity, meaning that it is a row in the database.
@Entity
public class quizScores {
    // Id is primary key as its always unique.
    @PrimaryKey
    public int id;
    public String username;
    public int score;

    // Constructors.
    public quizScores() {
    }

    public quizScores(int id, String username, int score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }

    //  private String quizType;
}

