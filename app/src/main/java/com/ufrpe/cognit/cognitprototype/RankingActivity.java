package com.ufrpe.cognit.cognitprototype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<StudentItem> studentItems = new ArrayList<>();
    private String currentName;
    private static int state;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        layout = findViewById(R.id.layout);

        if (state == 1){
            layout.setBackgroundResource(R.drawable.students_art);
        }

        listView = findViewById(R.id.recycler);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentName = studentItems.get(position).getName();
                showProfile();
            }
        });


        StudentItem item = new StudentItem("item_1", "José Soares", "321");
        studentItems.add(item);
        item = new StudentItem("item_2", "Mariana Silva", "281");
        studentItems.add(item);
        item = new StudentItem("item_3", " Ìcaro Moraes", "242");
        studentItems.add(item);
        item = new StudentItem("item_4", "Viviana Souza", "184");
        studentItems.add(item);
        item = new StudentItem("item_5", "Diego André", "94");
        studentItems.add(item);
        populate();
    }

    public static void setState(int state) {
        RankingActivity.state = state;
    }

    public void populate(){
        RankingAdapter adapter = new RankingAdapter(this, studentItems);
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

    private class RankingAdapter extends ArrayAdapter<StudentItem> {

        public RankingAdapter(@NonNull Context context, ArrayList<StudentItem> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            StudentItem item = getItem(position);
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
