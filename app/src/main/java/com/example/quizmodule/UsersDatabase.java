package com.example.quizmodule;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// This database holds the data surrounding the quiz results.
@Database(entities = {accountUsers.class}, version = 1, exportSchema = true)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UserDaoUsers userDaoUsers();
}
