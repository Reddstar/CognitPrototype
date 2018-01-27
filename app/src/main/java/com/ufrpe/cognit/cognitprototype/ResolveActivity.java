package com.ufrpe.cognit.cognitprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ResolveActivity extends AppCompatActivity {

    private int state = 0;
    private RelativeLayout layout;
    private ImageButton imageButton;
    private ImageButton magicButton;
    private boolean magicUsed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolve);

        layout = findViewById(R.id.layout);
        imageButton = findViewById(R.id.btn_screen);
        magicButton = findViewById(R.id.btn_magic);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState();
            }
        });
        magicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                magicUsed();
                changeState();
            }
        });
    }

    public void magicUsed(){
        magicUsed = true;
        state = 3;
    }

    public void changeState(){
        state += 1;
        if (state == 1){
            layout.setBackgroundResource(R.drawable.resolve_art_2);
        } else if (state == 2){
            layout.setBackgroundResource(R.drawable.resolve_art_3);
        } else if (state == 3){
            layout.setBackgroundResource(R.drawable.resolve_art_4);
            finalize();
        } else if (state == 4 && magicUsed){
            layout.setBackgroundResource(R.drawable.resolve_art_5);
        } else if (state == 5 && magicUsed){
            layout.setBackgroundResource(R.drawable.resolve_art_6);
        } else if (state == 6 && magicUsed){
            layout.setBackgroundResource(R.drawable.resolve_art_7);
        } else if (state == 7 && magicUsed){
            layout.setBackgroundResource(R.drawable.resolve_art_8);
            finalize();
        }
    }

    public void finalize(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Certo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intentBack = new Intent(ResolveActivity.this, TeacherContentActivity.class);
                finish();
                startActivity(intentBack);
            }
        });
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_victory, null);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(R.color.colorPrimary);
    }
}
