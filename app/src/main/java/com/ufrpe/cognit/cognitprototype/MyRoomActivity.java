package com.ufrpe.cognit.cognitprototype;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MyRoomActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<RoomItem> roomItems = new ArrayList<>();
    private ImageButton btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_room);

        listView = findViewById(R.id.recycler);
        btnCreate = findViewById(R.id.btn_create_room);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RankingActivity.setState(1);
                Intent goList = new Intent(MyRoomActivity.this, RankingActivity.class);
                startActivity(goList);
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goCreation = new Intent(MyRoomActivity.this, RoomCreationActivity.class);
                startActivity(goCreation);
            }
        });

        RoomItem item = new RoomItem("room_1");
        roomItems.add(item);
        item = new RoomItem("room_1");
        roomItems.add(item);
        populate();


    }

    public void populate(){
        MyRoomActivity.RankingAdapter adapter = new MyRoomActivity.RankingAdapter(this, roomItems);
        listView.setAdapter(adapter);
    }

    private class RankingAdapter extends ArrayAdapter<RoomItem> {

        public RankingAdapter(@NonNull Context context, ArrayList<RoomItem> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            RoomItem item = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_ranking_item, parent, false);
            }
            int resId = getResources().getIdentifier(item.getImageName(), "drawable", getPackageName());
            ImageView image = convertView.findViewById(R.id.image_ranking_item);
            image.setImageResource(resId);
            return convertView;
        }
    }
}
