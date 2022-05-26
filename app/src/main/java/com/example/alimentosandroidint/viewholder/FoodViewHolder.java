package com.example.alimentosandroidint.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentosandroidint.OnListClick;
import com.example.alimentosandroidint.R;
import com.example.alimentosandroidint.entity.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextCalories;

    public FoodViewHolder(@NonNull View itemView) {
        super( itemView );

        this.mTextName = itemView.findViewById( R.id.text_name );
        this.mTextCalories = itemView.findViewById( R.id.text_calories );

    }

    public void bind (FoodEntity food, OnListClick listener){
        this.mTextName.setText( food.getNome() );
        this.mTextCalories.setText( String.valueOf(food.getCalories()));

        //Evento de clique para abrir o item
        this.mTextName.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick( food.getId() );
            }
        } );
    }
}