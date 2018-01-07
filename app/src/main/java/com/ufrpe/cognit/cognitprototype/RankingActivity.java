package com.ufrpe.cognit.cognitprototype;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<RankingItem> rankingItems = new ArrayList<>();
    private String currentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        listView = findViewById(R.id.recycler);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentName = rankingItems.get(position).getName();
                showProfile();
            }
        });


        RankingItem item = new RankingItem("item_1", "José Soares", "321");
        rankingItems.add(item);
        item = new RankingItem("item_2", "Mariana Silva", "281");
        rankingItems.add(item);
        item = new RankingItem("item_3", " Ìcaro Moraes", "242");
        rankingItems.add(item);
        item = new RankingItem("item_4", "Viviana Souza", "184");
        rankingItems.add(item);
        item = new RankingItem("item_5", "Diego André", "94");
        rankingItems.add(item);
        populate();
    }

    public void populate(){
        RankingAdapter adapter = new RankingAdapter(this, rankingItems);
        listView.setAdapter(adapter);
    }

    public void showProfile(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_view, null);
        TextView text = dialogView.findViewById(R.id.textName);
        text.setText(currentName);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(R.color.colorPrimary);
    }

    private class RankingAdapter extends ArrayAdapter<RankingItem> {

        public RankingAdapter(@NonNull Context context, ArrayList<RankingItem> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            RankingItem item = getItem(position);
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
