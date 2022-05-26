package com.example.alimentosandroidint.business;

import com.example.alimentosandroidint.entity.FoodEntity;
import com.example.alimentosandroidint.repository.FoodRepository;

import java.util.List;

public class FoodBusiness {

    public FoodEntity get(int id){
        return new FoodRepository().get( id );
    }

    public List<FoodEntity> getList(){
        return new FoodRepository().getList();
    }
}
