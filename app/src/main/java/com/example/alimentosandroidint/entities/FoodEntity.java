package com.example.alimentosandroidint.entities;

public class FoodEntity {

    //Essa classe funciona como um model
    private int id;
    private String nome;
    private int calories;
    private int quantity;
    private String unit;
    private String description;

    //Construtor
    public FoodEntity(int id, String nome, int calories, int quantity, String unit, String description){
        this.id = id;
        this.nome = nome;
        this.calories = calories;
        this.quantity = quantity;
        this.unit = unit;
        this.description = description;
    }

    //Métodos get & set
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
