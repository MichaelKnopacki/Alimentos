package com.example.alimentosandroidint.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.alimentosandroidint.services.listener.OnListClick;
import com.example.alimentosandroidint.ui.adapter.FoodAdapter;
import com.example.alimentosandroidint.services.business.FoodBusiness;
import com.example.alimentosandroidint.services.constants.FoodConstants;
import com.example.alimentosandroidint.entities.FoodEntity;
import com.example.alimentosandroidint.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private FoodBusiness mFoodBusiness = new FoodBusiness();
    private OnListClick mListener;
    private int mFilter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //Chama a interface
        this.mListener = new OnListClick() {
            @Override
            public void onClick(int id) {

                Bundle bundle = new Bundle();
                bundle.putInt( FoodConstants.FOOD_ID, id );

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras( bundle );
                //bundle, aceita vários valores. Nesse caso além do ID;

                startActivity( intent );
            }
        };

        // Obtem a recycler view
        this.mViewHolder.mRecyclerFood = findViewById( R.id.recycler_food );
        // definir um layout
        this.mViewHolder.mRecyclerFood.setLayoutManager( new LinearLayoutManager( this ) );

        this.listFood();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.action_menu, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.setChecked( true ); //aparece o item clicado

        switch (item.getItemId()){
            case R.id.filter_low: {
                this.mFilter = FoodConstants.FILTER.CAL_LOW;
                break;
            }
            case R.id.filter_medium: {
                this.mFilter = FoodConstants.FILTER.CAL_MEDIUM;
                break;
            }
            default:{
                this.mFilter = FoodConstants.FILTER.CAL_HIGH;
                break;
            }
        }

        this.listFood();
        return super.onOptionsItemSelected( item );
    }

    private void listFood(){

        //Pega lista declarada no FoodRepository
        List<FoodEntity> list = this.mFoodBusiness.getList(this.mFilter);
        // Definir um adapter
        FoodAdapter adapter = new FoodAdapter(list, this.mListener );
        this.mViewHolder.mRecyclerFood.setAdapter( new FoodAdapter( list, this.mListener ) );


    }

    //Listando os elementos de interface, para manipular
    private static class ViewHolder{
        RecyclerView mRecyclerFood;
    }
}