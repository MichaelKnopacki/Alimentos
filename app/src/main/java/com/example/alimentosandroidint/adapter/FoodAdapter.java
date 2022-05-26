package com.example.alimentosandroidint.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentosandroidint.OnListClick;
import com.example.alimentosandroidint.R;
import com.example.alimentosandroidint.entity.FoodEntity;
import com.example.alimentosandroidint.viewholder.FoodViewHolder;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List <FoodEntity> mList;
    private OnListClick mListClick;
    public FoodAdapter(List<FoodEntity> list, OnListClick listener){
        this.mList = list;
        this.mListClick = listener;
    }

    //Criado a linha do Recycler View - inflar
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from( context );

        View view = inflater.inflate ( R.layout.item_food, parent, false);
        return  new FoodViewHolder( view );
    }

    //Atribuido os valores ao layout
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodEntity foodEntity = this.mList.get( position );
        holder.bind(foodEntity, this.mListClick);

    }

    //Conta a quantidade de elementos
    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
