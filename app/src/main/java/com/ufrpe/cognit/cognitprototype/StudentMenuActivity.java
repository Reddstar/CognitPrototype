package com.ufrpe.cognit.cognitprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StudentMenuActivity extends AppCompatActivity {

    private ImageButton btnRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnRanking = findViewById(R.id.btn_ranking);

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goRanking = new Intent(StudentMenuActivity.this, RankingActivity.class);
                startActivity(goRanking);
            }
        });
    }
}
