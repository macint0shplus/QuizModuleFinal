package com.example.quizmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView username_TV;
    private TextView password_TV;
    private EditText userUsername_TV;
    private EditText userPassword_TV;
    private Button login_BT;
    private Button signup_BT;
    private TextView errorMessage_TV;
    String tempUsername = "";
    String tempPassword = "";
    String username = "";
    String password = "";
    boolean validUser = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_TV = findViewById(R.id.username_TV);
        password_TV = findViewById(R.id.password_TV);
        userUsername_TV = findViewById(R.id.userUsername_ET);
        userPassword_TV = findViewById(R.id.userPassword_ET);
        login_BT = findViewById(R.id.signUp_BT);
        signup_BT = findViewById(R.id.signup_BT);
        errorMessage_TV = findViewById(R.id.errorMessage_TV);
        errorMessage_TV.setVisibility(View.INVISIBLE);

        login_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempUsername = userUsername_TV.getText().toString();
                // System.out.println
                tempPassword = userPassword_TV.getText().toString();
                //login(tempUsername, tempPassword);
                new getUserDetailsTask().execute();


            }
        });

        signup_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempUsername = userUsername_TV.getText().toString();
                // System.out.println
                tempPassword = userPassword_TV.getText().toString();
                signup();
            }
        });
    }


    // will change to ROOM
    private class getUserDetailsTask extends AsyncTask<Void, Void, accountUsers> {
        @Override
        protected accountUsers doInBackground(Void... voids) {
            UsersDatabase usersDB = Room.databaseBuilder(getApplicationContext(), UsersDatabase.class, "users-database").build();
            return usersDB.userDaoUsers().getUsernameByString(tempUsername);
        }

        @Override
        protected void onPostExecute(accountUsers tempUser) {
System.out.println(tempUser.password + "    passs");
            if (tempUser == null) {
                errorMessage_TV.setVisibility(View.VISIBLE);
            }else if ((tempUser.username.equals(tempUsername)) && (tempUser.password.equals(tempPassword))) {
                login();

            } else {
                errorMessage_TV.setVisibility(View.VISIBLE);
            }

        }
    }


    public void signup() {
        Intent intent = new Intent(this, signupPage.class);
        startActivity(intent);
    }

    public void login() {
        Intent intent = new Intent(this, quizSelectionPage.class);
        intent.putExtra("username", tempUsername);
        startActivity(intent);
    }

}
