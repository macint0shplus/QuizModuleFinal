package com.example.quizmodule;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDaoScores {
    // To show name of current logged in user


    @Query("SELECT id, username,score FROM quizScores ORDER BY score LIMIT 5")
    List<quizScores> getTopFiveQuizScores();

}