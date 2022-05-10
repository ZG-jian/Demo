package com.jianjian.homework;

public class Commodity {
    private int Id;
    private String name;
    private String model;
    private double price;
    private double discount;

    @Override
    public String toString(){
        return "["+getId()+","+getName()+","+getModel()+","+getPrice()+","+getDiscount()+"]";
    }

    public Commodity(){

    }

    public Commodity(int id, String name, String model, double price, double discount) {
        Id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.discount = discount;
    }




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
