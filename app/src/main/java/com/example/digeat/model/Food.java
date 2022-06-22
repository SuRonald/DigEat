package com.example.digeat.model;

public class Food {
    int foodImg;
    String foodName;
    Integer foodPrice, foodId, foodSales;

    public Food(int foodImg, String foodName, Integer foodPrice, Integer foodId, Integer foodSales) {
        this.foodImg = foodImg;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodId = foodId;
        this.foodSales = foodSales;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg = foodImg;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Integer foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodSales() {
        return foodSales;
    }

    public void setFoodSales(Integer foodSales) {
        this.foodSales = foodSales;
    }
}
