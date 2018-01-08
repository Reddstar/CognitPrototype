package com.ufrpe.cognit.cognitprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TeacherMenuActivity extends AppCompatActivity {

    ImageButton btnRooms;
    ImageButton btnTeacherActivities;
    ImageButton btnContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_menu);

        btnRooms = findViewById(R.id.btn_rooms);
        btnTeacherActivities = findViewById(R.id.btn_activities);
        btnContent = findViewById(R.id.btn_content);

        btnRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goRooms = new Intent(TeacherMenuActivity.this, MyRoomActivity.class);
                startActivity(goRooms);
            }
        });
        btnTeacherActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goActivities = new Intent(TeacherMenuActivity.this, ClassesActivity.class);
                startActivity(goActivities);
            }
        });
        btnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goContent = new Intent(TeacherMenuActivity.this, ContentCreationActivity.class);
                startActivity(goContent);
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
