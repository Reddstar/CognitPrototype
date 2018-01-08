package com.ufrpe.cognit.cognitprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class ResolveActivity extends AppCompatActivity {

    private int state = 0;
    private RelativeLayout layout;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolve);

        layout = findViewById(R.id.layout);
        imageButton = findViewById(R.id.btn_screen);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState();
            }
        });
    }

    public void changeState(){
        state += 1;
        if (state == 1){
            layout.setBackgroundResource(R.drawable.resolve_art_2);
        } else if (state == 2){
            layout.setBackgroundResource(R.drawable.resolve_art_3);
        } else if (state == 3){
            layout.setBackgroundResource(R.drawable.resolve_art_4);
        }
    }
}
