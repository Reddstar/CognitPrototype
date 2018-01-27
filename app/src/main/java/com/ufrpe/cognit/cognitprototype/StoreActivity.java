package com.ufrpe.cognit.cognitprototype;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class StoreActivity extends AppCompatActivity {

    private ImageButton buy;
    private boolean state = false;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        layout = findViewById(R.id.layout);
        buy = findViewById(R.id.btn_buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyMagic();
            }
        });
    }

    public void buyMagic(){
        showBuyDialog();
    }

    public void changeState(){
        state = true;
        layout.setBackgroundResource(R.drawable.store_art_2);
    }

    public void showBuyDialog(){
        if (state){
            AlertDialog builder = new AlertDialog.Builder(this)
                    .setTitle("Sem saldo =(")
                    .setMessage("Você não tem moedas suficientes?")
                    .setPositiveButton("SIM", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }

                    })
                    .setNegativeButton("NÃO", null)
                    .show();
            builder.show();
        } else {
            AlertDialog builder = new AlertDialog.Builder(this)
                    .setTitle("Confirme compra")
                    .setMessage("Deseja comprar Exemplo de Bônus por 1000 moedas?")
                    .setPositiveButton("SIM", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            changeState();
                        }

                    })
                    .setNegativeButton("NÃO", null)
                    .show();
            builder.show();
        }
    }
}
