package com.muhammad_adi_yusuf.gameboss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Game> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.recycleview);
        rvCategory.setHasFixedSize(true);

        list.addAll(GameData.getListData());
        showRecycleList();
    }

    private void showRecycleList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListGameAdapter listGameAdapter = new ListGameAdapter(this);
        listGameAdapter.setListGame(list);
        rvCategory.setAdapter(listGameAdapter);

    }

}
