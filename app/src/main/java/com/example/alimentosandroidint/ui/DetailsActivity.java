package com.example.alimentosandroidint.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alimentosandroidint.R;
import com.example.alimentosandroidint.business.FoodBusiness;
import com.example.alimentosandroidint.constants.FoodConstants;
import com.example.alimentosandroidint.entity.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewholder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
        }


        // Elementos de interface
        this.mViewholder.mTextName = findViewById( R.id.text_name );
        this.mViewholder.mTextCalories = findViewById( R.id.text_calories );

        this.getData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected( item );
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        if ( bundle != null) {
            int id = bundle.getInt( FoodConstants.FOOD_ID );
            FoodEntity foodEntity = new FoodBusiness().get( id );

            this.mViewholder.mTextName.setText( foodEntity.getNome() );
            this.mViewholder.mTextCalories.setText(String.valueOf( foodEntity.getCalories()));

        }
    }

    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;

    }
}