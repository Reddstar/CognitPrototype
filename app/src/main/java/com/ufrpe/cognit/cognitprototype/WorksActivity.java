package com.ufrpe.cognit.cognitprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WorksActivity extends AppCompatActivity {

    private ImageButton btnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works);

        btnActivity = findViewById(R.id.btn_student_activities);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent goResolve = new Intent(WorksActivity.this, ClassesActivity.class);
                    startActivity(goResolve);
            }
        });

    }
}
