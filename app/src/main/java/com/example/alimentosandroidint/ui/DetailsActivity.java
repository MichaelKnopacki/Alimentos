package com.example.alimentosandroidint.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alimentosandroidint.R;
import com.example.alimentosandroidint.services.business.FoodBusiness;
import com.example.alimentosandroidint.services.constants.FoodConstants;
import com.example.alimentosandroidint.entities.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewholder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Onde a tela é iniciada
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );

        //Habilita o botão voltar na barra superior
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            getSupportActionBar().setDisplayShowHomeEnabled( true );
        }

        // Elementos de interface
        this.mViewholder.mTextName = findViewById( R.id.text_name );
        this.mViewholder.mTextCalories = findViewById( R.id.text_calories );
        this.mViewholder.mTextQuantity = findViewById( R.id.text_quantity );
        this.mViewholder.mTextUnit = findViewById( R.id.text_unit );
        this.mViewholder.mTextDescription = findViewById( R.id.text_description );

        this.getData();
    }

    // Configurou o botão voltar da barra superior
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();//Para encerrar o ciclo de vida da activity
        }
        return super.onOptionsItemSelected( item );
    }

    //Carrega a informção quando o item é clicado
    private void getData(){
        Bundle bundle = getIntent().getExtras();
        if ( bundle != null) {
            int id = bundle.getInt( FoodConstants.FOOD_ID );
            FoodEntity foodEntity = new FoodBusiness().get( id );

            this.mViewholder.mTextName.setText( foodEntity.getNome() );
            this.mViewholder.mTextQuantity.setText( String.valueOf( foodEntity.getQuantity() ) );
            this.mViewholder.mTextUnit.setText( foodEntity.getUnit());

            String strCalories = String.format( "%s %s ", foodEntity.getCalories(), this.getString( R.string.calorias ) );
            this.mViewholder.mTextCalories.setText(strCalories);

            if( !"".equals( foodEntity.getDescription() )) {
                this.mViewholder.mTextDescription.setText( foodEntity.getDescription() );
            }

        }
    }

    //Listando os elementos de interface, para manipular
    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
        TextView mTextQuantity;
        TextView mTextUnit;
        TextView mTextDescription;

    }
}