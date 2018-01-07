package com.ufrpe.cognit.cognitprototype;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Structure structure = new Structure();
    private ImageButton btnConfirm;
    private EditText edtCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfirm = findViewById(R.id.btn_confirm);
        edtCode = findViewById(R.id.edit_code);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (defineProfile(edtCode.getText().toString())){
                    Intent intentTeacher = new Intent(MainActivity.this, TeacherMenuActivity.class);
                    startActivity(intentTeacher);
                    finish();
                } else {
                    Intent intentTeacher = new Intent(MainActivity.this, StudentMenuActivity.class);
                    startActivity(intentTeacher);
                    finish();
                }
            }
        });
    }

    private boolean defineProfile(String text){
        return text.equals(structure.getTeacherCode());
    }
}
