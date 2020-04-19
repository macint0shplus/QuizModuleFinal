package com.example.quizmodule;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// This database holds the data surrounding the quiz results.
@Database(entities = {quizScores.class}, version = 1)
public abstract class ScoresDatabase extends RoomDatabase {
    public abstract UserDaoScores userDaoScores();
}
