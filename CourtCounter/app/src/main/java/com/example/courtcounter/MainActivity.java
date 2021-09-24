package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA=0,scoreB=0;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void resetscore(View view)
    {
        scoreA=0;
        displayForTeamA(scoreA);
        scoreB=0;
        displayForTeamB(scoreB);

    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score1);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score2);
        scoreView.setText(String.valueOf(score));
    }
    public void threepointera(View view)
    {
        scoreA+=3;
        displayForTeamA(scoreA);
    }
    public void threepointerb(View view)
    {
        scoreB+=3;
        displayForTeamB(scoreB);
    }
    public void twopointera(View view)
    {
        scoreA+=2;
        displayForTeamA(scoreA);
    }
    public void twopointerb(View view)
    {
        scoreB+=2;
        displayForTeamB(scoreB);
    }
    public void freethrowa(View view)
    {
        scoreA++;
        displayForTeamA(scoreA);
    }
    public void freethrowb(View view)
    {
        scoreB++;
        displayForTeamB(scoreB);
    }


}