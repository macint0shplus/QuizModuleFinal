package com.example.quizmodule;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {quizScores.class}, version = 1)
public abstract class ScoresDatabase extends RoomDatabase {
    public abstract UserDaoScores userDaoScores();
}
