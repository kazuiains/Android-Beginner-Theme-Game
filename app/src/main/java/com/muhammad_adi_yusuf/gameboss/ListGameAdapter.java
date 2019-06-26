package com.muhammad_adi_yusuf.gameboss;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListGameAdapter extends RecyclerView.Adapter<ListGameAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Game> listGame;

    public ListGameAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Game> getListGame() {
        return listGame;
    }

    public void setListGame(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_game_update, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        final String cname = getListGame().get(position).getName();
        final String cgenre = getListGame().get(position).getGenre();
        final String cphoto = getListGame().get(position).getPhoto();
        final String cprice = getListGame().get(position).getPrice();
        final String cplatform = getListGame().get(position).getPlatform();
        final String cdeveloper = getListGame().get(position).getDeveloper();
        final String cpublisher = getListGame().get(position).getPublisher();
        final String crelease = getListGame().get(position).getRelease();
        final String cdetail = getListGame().get(position).getDetail();

        categoryViewHolder.tvName.setText(getListGame().get(position).getName());
        categoryViewHolder.tvGenre.setText(getListGame().get(position).getGenre());

        Glide.with(context)
                .load(getListGame().get(position).getPhoto())
                .apply(new RequestOptions().override(120, 68))
                .into(categoryViewHolder.imgPhoto1);

        categoryViewHolder.tvPrice.setText(getListGame().get(position).getPrice());

        Glide.with(context)
                .load(getListGame().get(position).getPlatform())
                .apply(new RequestOptions().override(20, 20))
                .into(categoryViewHolder.imgPhoto2);

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("ggname",cname);
                intent.putExtra("gggenre",cgenre);
                intent.putExtra("ggphoto",cphoto);
                intent.putExtra("ggprice",cprice);
                intent.putExtra("ggplatform",cplatform);
                intent.putExtra("ggdeveloper",cdeveloper);
                intent.putExtra("ggpublisher",cpublisher);
                intent.putExtra("ggrelease",crelease);
                intent.putExtra("ggdetail",cdetail);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListGame().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvGenre;
        ImageView imgPhoto1;
        TextView tvPrice;
        ImageView imgPhoto2;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.judul_game);
            tvGenre = itemView.findViewById(R.id.genre_game);
            imgPhoto1 = itemView.findViewById(R.id.foto_game);
            tvPrice = itemView.findViewById(R.id.harga_game);
            imgPhoto2 = itemView.findViewById(R.id.platform_game);

        }
    }
}
