package com.ufrpe.cognit.cognitprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StudentMenuActivity extends AppCompatActivity {

    private ImageButton btnRanking;
    private ImageButton btnClasses;
    private ImageButton btnStore;
    private ImageButton btnAchievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnRanking = findViewById(R.id.btn_ranking);
        btnClasses = findViewById(R.id.btn_classes);
        btnStore = findViewById(R.id.btn_store);
        btnAchievements = findViewById(R.id.btn_achievements);

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RankingActivity.setState(0);
                Intent goRanking = new Intent(StudentMenuActivity.this, RankingActivity.class);
                startActivity(goRanking);
            }
        });
        btnClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goClasses = new Intent(StudentMenuActivity.this, ClassesActivity.class);
                startActivity(goClasses);
            }
        });
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goStore = new Intent(StudentMenuActivity.this, StoreActivity.class);
                startActivity(goStore);
            }
        });
        btnAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goAchievements = new Intent(StudentMenuActivity.this, AchievementsActivity.class);
                startActivity(goAchievements);
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog builder = new AlertDialog.Builder(this)
                .setTitle("Saindo")
                .setMessage("Deseja sair da aplicação?")
                .setPositiveButton("SIM", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("NÃO", null)
                .show();
        builder.show();
    }
}
