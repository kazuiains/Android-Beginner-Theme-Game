package com.muhammad_adi_yusuf.gameboss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    //GlobalVariable
    ImageView gambar_game_detail;
    String dname, dgenre, dphoto, dprice, dplatform, ddeveloper, dpublisher, drelease, ddetail;
    TextView detailname, detailabout, detailtitle, detailgenre, detaildeveloper, detailpublisher, detailrelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        castingView();
        setData();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(dname);

    }

    private void castingView() {
        detailabout = findViewById(R.id.detail_about);
        detailtitle = findViewById(R.id.detail_title);
        detailgenre = findViewById(R.id.detail_genre);
        detaildeveloper = findViewById(R.id.detail_developer);
        detailpublisher = findViewById(R.id.detail_publisher);
        detailrelease = findViewById(R.id.detail_release);
        gambar_game_detail = findViewById(R.id.background_game);

    }

    private void setData() {
        try {
            dname = getIntent().getStringExtra("ggname");
            dgenre = getIntent().getStringExtra("gggenre");
            dphoto = getIntent().getStringExtra("ggphoto");
            dprice = getIntent().getStringExtra("ggprice");
            dplatform = getIntent().getStringExtra("ggplatform");
            ddeveloper = getIntent().getStringExtra("ggdeveloper");
            dpublisher = getIntent().getStringExtra("ggpublisher");
            drelease = getIntent().getStringExtra("ggrelease");
            ddetail = getIntent().getStringExtra("ggdetail");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle(dname);
        detailabout.setText(ddetail);
        detailtitle.setText(dname);
        detailgenre.setText(dgenre);
        detaildeveloper.setText(ddeveloper);
        detailpublisher.setText(dpublisher);
        detailrelease.setText(drelease);

        Glide.with(this)
                .load(dphoto)
                .into(gambar_game_detail);
       }

}
