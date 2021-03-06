package com.ufrpe.cognit.cognitprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ClassesActivity extends AppCompatActivity {

    public static int state;

    ImageButton btnActivity;
    ImageButton btnChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        btnActivity = findViewById(R.id.btn_student_activities);
        btnChallenge = findViewById(R.id.btn_challenge);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    Intent goResolve = new Intent(ClassesActivity.this, TeacherContentActivity.class);
                    startActivity(goResolve);
                }
            }
        });

        btnChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    Intent goResolve = new Intent(ClassesActivity.this, ResolveActivity.class);
                    startActivity(goResolve);
                } else if (state == 1){
                    Intent goResolve = new Intent(ClassesActivity.this, TeacherContentActivity.class);
                    startActivity(goResolve);
                }
            }
        });
    }
}
