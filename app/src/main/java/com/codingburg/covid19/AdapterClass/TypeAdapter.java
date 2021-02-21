package com.codingburg.covid19.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.codingburg.covid19.R;
import com.codingburg.covid19.ModelData.TypeData;


import java.util.List;

public class TypeAdapter  extends RecyclerView.Adapter<TypeAdapter.ProductViewHolder> {
    private final Context mCtx;
    private final List<TypeData> productList;

    public TypeAdapter(Context mCtx, List<TypeData> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public TypeAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.movie_type, null);
        return new TypeAdapter.ProductViewHolder(view);
    }



    @Override
    public void onBindViewHolder(TypeAdapter.ProductViewHolder holder, int position) {
        TypeData movieData = productList.get(position);

        //loading the image
        holder.id.setText(movieData.getId());
        holder.name.setText(movieData.getName());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView id, name;


        public ProductViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.type);
        }

        @Override
        public void onClick(View v) {

        }
    }
}