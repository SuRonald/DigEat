package com.example.digeat.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.digeat.databases.Database;
import com.example.digeat.model.Food;

import java.util.Vector;

public class FoodHelper {

    private final String TABLE_NAME = "Food";
    private Database databases;
    private SQLiteDatabase db;

    public FoodHelper(Context context){
        databases = new Database(context);
    }

    // insert
    public void dbFoodInsert(Food food){
        db = databases.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FoodID", food.getFoodId());
        contentValues.put("FoodName", food.getFoodName());
        contentValues.put("FoodPrice", food.getFoodPrice());
        contentValues.put("FoodImage", food.getFoodImg());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    //read
    public Vector<Food> dbFoodRead(){
        db = databases.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Food", null);
        cursor.moveToFirst();

        Vector<Food> temp = new Vector<>();
        Integer foodId, foodPrice, foodSales;
        String foodName;
        int foodImg;

        if (cursor != null && cursor.getCount() > 0){
            do {
                foodId = cursor.getInt(cursor.getColumnIndexOrThrow("FoodID"));
                foodName = cursor.getString(cursor.getColumnIndexOrThrow("FoodName"));
                foodPrice = cursor.getInt(cursor.getColumnIndexOrThrow("FoodPrice"));
                foodImg = cursor.getInt(cursor.getColumnIndexOrThrow("FoodImage"));
                foodSales = cursor.getInt(cursor.getColumnIndexOrThrow("FoodSales"));

                temp.add(new Food(foodImg, foodName, foodPrice, foodId, foodSales));

                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        db.close();
        return temp;
    }

    //update
    public void dbAddFoodSales(Food food){
        db = databases.getWritableDatabase();
        Integer newFoodSales = food.getFoodSales();
        newFoodSales = newFoodSales + 1;
        ContentValues cv = new ContentValues();
        cv.put("FoodSales", newFoodSales);
        db.update(TABLE_NAME, cv, "FoodID = ?", new String[]{food.getFoodId() + ""});
        db.close();
    }

    public void dbFoodClear(){
        db = databases.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

}
