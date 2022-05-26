package com.example.alimentosandroidint.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.alimentosandroidint.OnListClick;
import com.example.alimentosandroidint.adapter.FoodAdapter;
import com.example.alimentosandroidint.business.FoodBusiness;
import com.example.alimentosandroidint.constants.FoodConstants;
import com.example.alimentosandroidint.entity.FoodEntity;
import com.example.alimentosandroidint.R;
import com.example.alimentosandroidint.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        List<FoodEntity> list = new FoodBusiness().getList();

        // Obter a recycler view
        this.mViewHolder.mRecyclerFood = findViewById( R.id.recycler_food );

        OnListClick foodListener = new OnListClick() {
            @Override
            public void onClick(int id) {

                Bundle bundle = new Bundle();
                bundle.putInt( FoodConstants.FOOD_ID, id );

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras( bundle );

                startActivity( intent );
            }
        };

        // Definir um adapter
        FoodAdapter adapter = new FoodAdapter(list, foodListener );
        this.mViewHolder.mRecyclerFood.setAdapter( adapter );

        // definir um layout
        this.mViewHolder.mRecyclerFood.setLayoutManager( new LinearLayoutManager( this ) );
    }

    private static class ViewHolder{
        RecyclerView mRecyclerFood;
    }
}