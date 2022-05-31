package com.example.alimentosandroidint.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentosandroidint.services.listener.OnListClick;
import com.example.alimentosandroidint.R;
import com.example.alimentosandroidint.entities.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextCalories;
    private TextView mTextQuantity;
    private TextView mTextUnit;

    private Context mContext;

    public FoodViewHolder(@NonNull View itemView) {
        super( itemView );

        this.mContext = itemView.getContext();

        this.mTextName = itemView.findViewById( R.id.text_name );//mapeou o item
        this.mTextCalories = itemView.findViewById( R.id.text_calories );//mapeou o item
        this.mTextQuantity = itemView.findViewById( R.id.text_quantity );//mapeou o item
        this.mTextUnit = itemView.findViewById( R.id.text_unit );//mapeou o item
    }

    public void bind (FoodEntity food, OnListClick listener){
        this.mTextName.setText( food.getNome() );//instância

        String strCalories = String.format( "%s %s ", food.getCalories(), this.mContext.getString( R.string.calorias ) );
        this.mTextCalories.setText( strCalories);//instância
        this.mTextQuantity.setText( String.valueOf(food.getQuantity()));//instância
        this.mTextUnit.setText( String.valueOf(food.getUnit()));//instância

        //Evento de clique para abrir o item
        this.mTextName.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick( food.getId() );
            }
        } );
    }
}
