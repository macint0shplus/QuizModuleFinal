package com.example.quizmodule;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// DAO translator between UsersDatabase and related functions.
@Dao
public interface UserDaoScores {
    // Query to ger the top 5 quiz scores for the leaderboard.
    @Query("SELECT id, username,score FROM quizScores WHERE type =:name ORDER BY score LIMIT 5")
    List<quizScores> getTopFiveQuizScores(String name);

    // Insert to add new score.
    @Insert
    void insertScores(quizScores scores);

  //  @Query ("DELETE FROM quizScores")
 //   public void nuke();


}

//