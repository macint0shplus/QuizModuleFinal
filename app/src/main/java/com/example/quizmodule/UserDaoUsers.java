package com.example.quizmodule;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// DAO translator between UsersDatabase and related functions.
@Dao
public interface UserDaoUsers {
    // Query to show the details of a certain user.
    @Query("SELECT username, password FROM accountUsers WHERE username = :tempUsername")
    accountUsers getUsernameByString(String tempUsername);

    // Insert to add new user.
    @Insert
    void insert(accountUsers user);
}