package com.ufrpe.cognit.cognitprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MyInfoActivity extends AppCompatActivity {

    ImageButton btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        btnContinue = findViewById(R.id.btn_confirm);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goRooms = new Intent(MyInfoActivity.this, StudentMenuActivity.class);
                startActivity(goRooms);
            }
        });
    }
}
