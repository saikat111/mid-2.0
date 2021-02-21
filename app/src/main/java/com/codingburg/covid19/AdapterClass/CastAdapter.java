package com.codingburg.covid19.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codingburg.covid19.R;
import com.codingburg.covid19.ModelData.Cast;


import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.ProductViewHolder> {
    private static final String IMAGE_PRODUCTS = "https://image.tmdb.org/t/p/w500";
    private final Context mCtx;
    private final List<Cast> productList;

    public CastAdapter(Context mCtx, List<Cast> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public CastAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cast, null);
        return new CastAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CastAdapter.ProductViewHolder holder, int position) {
        Cast movieData = productList.get(position);

        //loading the image

        Glide.with(mCtx)
                .load(IMAGE_PRODUCTS + movieData.getProfile_path())
                .into(holder.poster);

        holder.name.setText(movieData.getName());


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView poster;

        public ProductViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            poster = itemView.findViewById(R.id.poster);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
