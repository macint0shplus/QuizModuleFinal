package com.example.quizmodule;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDaoUsers {
    // To show name of current logged in user
    @Query("SELECT username, password FROM accountUsers WHERE username = :tempUsername")
    accountUsers getUsernameByString(String tempUsername);

    // Add new user
    @Insert
    void insert(accountUsers user);
}