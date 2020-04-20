package com.example.quizmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class QuizLeaderboardActivity extends AppCompatActivity {

    private TextView first_TV;
    private TextView second_TV;
    private TextView third_TV;
    private TextView fourth_TV;
    private TextView fifth_TV;

    private TextView firstUser_TV;
    private TextView secondUser_TV;
    private TextView thirdUser_TV;
    private TextView fourthUser_TV;
    private TextView fifthUser_TV;

    private TextView firstScore_TV;
    private TextView secondScore_TV;
    private TextView thirdScore_TV;
    private TextView fourthScore_TV;
    private TextView fifthScore_TV;

    private String quizName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_scores_table);

        first_TV = findViewById(R.id.first_TV);
        second_TV = findViewById(R.id.second_TV);
        third_TV = findViewById(R.id.third_TV);
        fourth_TV = findViewById(R.id.fourth_TV);
        fifth_TV = findViewById(R.id.fifth_TV);

        firstUser_TV = findViewById(R.id.firstUser_TV);
        secondUser_TV = findViewById(R.id.secondUser_TV);
        thirdUser_TV = findViewById(R.id.thirdUser_TV);
        fourthUser_TV = findViewById(R.id.fourthUser_TV);
        fifthUser_TV = findViewById(R.id.fifthUser_TV);

        firstScore_TV = findViewById(R.id.firstScore_TV);
        secondScore_TV = findViewById(R.id.secondScore_TV);
        thirdScore_TV = findViewById(R.id.thirdScore_TV);
        fourthScore_TV = findViewById(R.id.fourthScore_TV);
        fifthScore_TV = findViewById(R.id.fifthScore_TV);

        Intent intent = getIntent();
        quizName = intent.getStringExtra("quizName");

      new getTopFiveQuizScoresTask().execute();




    }

    private class getTopFiveQuizScoresTask extends AsyncTask<Void, Void, List<quizScores>> {
        @Override
        protected List<quizScores> doInBackground(Void... voids) {
            ScoresDatabase scoreDB = Room.databaseBuilder(getApplicationContext(), ScoresDatabase.class, "scores-database").build();
            return scoreDB.userDaoScores().getTopFiveQuizScores(quizName);
        }

        @Override
        protected void onPostExecute(List<quizScores> quizScores) {
           if(quizScores.get(0) != null) {
               firstUser_TV.setText(quizScores.get(0).username);
               System.out.println("USERNAME USERNAME USERNAME :" + quizScores.get(0).username);
               System.out.println("SCORE SCORE SCORE :" + quizScores.get(0).score);
               firstScore_TV.setText(Integer.toString(quizScores.get(0).score));
           }
// just take the length LMAO
            if(quizScores.get(1) != null) {
                secondUser_TV.setText(quizScores.get(1).username);
                secondScore_TV.setText(quizScores.get(1).score);
            }

            if(quizScores.get(2) != null) {
                thirdUser_TV.setText(quizScores.get(2).username);
                thirdScore_TV.setText(quizScores.get(2).score);
            }

            if(quizScores.get(3) != null) {
                fourthUser_TV.setText(quizScores.get(3).username);
                fourthScore_TV.setText(quizScores.get(4).score);
            }

            if(quizScores.get(4) != null) {
                fifthUser_TV.setText(quizScores.get(4).username);
                fifthScore_TV.setText(quizScores.get(4).score);
            }
        }
    }
// put in the scores table

}
