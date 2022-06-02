package com.example.alimentosandroidint.services.business;

import com.example.alimentosandroidint.services.constants.FoodConstants;
import com.example.alimentosandroidint.entities.FoodEntity;
import com.example.alimentosandroidint.services.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//Responsável pela lógica de negócio
public class FoodBusiness {

    private FoodRepository mFoodRepository = new FoodRepository();
    private String mLanguage;

    public FoodBusiness(){
        this.mLanguage = Locale.getDefault().getLanguage();
    }


    public FoodEntity get(int id){
        return this.mFoodRepository.get( id, this.mLanguage );
    }

    //Uma regra de negócio para o filtro da actionBar
    public List<FoodEntity> getList(int filter){

        Locale.getDefault().getLanguage();
        List<FoodEntity> list = this.mFoodRepository.getList(this.mLanguage);
        List<FoodEntity> filtered = new ArrayList<>();

        //Sem filtro ele carrega a lista toda
        if (filter == FoodConstants.FILTER.NO_FILTER){
            return list;
        }

        //filtrando o menu conforme as calorias
        for (FoodEntity f: list){
            if (filter == FoodConstants.FILTER.CAL_LOW){
                if (f.getCalories() <= 99){
                    filtered.add( f );
                }
            } else if (filter== FoodConstants.FILTER.CAL_MEDIUM) {
                if (f.getCalories() >= 100 && f.getCalories() <= 199) {
                    filtered.add( f );
                }
            } else if (filter== FoodConstants.FILTER.CAL_HIGH) {
                if (f.getCalories() >= 200) {
                    filtered.add( f );
                }
            }
        }
        return filtered;
    }
}
