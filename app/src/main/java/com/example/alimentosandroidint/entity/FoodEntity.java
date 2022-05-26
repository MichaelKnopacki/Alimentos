package com.example.alimentosandroidint.entity;

public class FoodEntity {

    private int id;
    private String nome;
    private int calories;

    public FoodEntity(int id, String nome, int calories){
        this.id = id;
        this.nome = nome;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
