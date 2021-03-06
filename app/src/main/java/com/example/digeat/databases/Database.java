package com.example.digeat.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    String query;

    private final String CREATE_TABLE_USERS = "CREATE TABLE User(UserID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "UserName TEXT not null," +
            "UserEmailAddress not null," +
            "UserPassword TEXT not null," +
            "UserType INTEGER not null," +
            "UserWallet INTEGER)";

    private final String CREATE_TABLE_TRANSACTIONS = "CREATE TABLE Transactions(TransactionID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "CustomerID INTEGER not null," +
            "Date TEXT not null," +
            "TotalPrice INTEGER not null," +
            "FOREIGN KEY (CustomerID) REFERENCES User (UserID))";

    private final String CREATE_TABLE_FOODS = "CREATE TABLE Food(FoodID INTEGER PRIMARY KEY," +
            "FoodName TEXT not null," +
            "FoodPrice INTEGER not null," +
            "FoodImage INTEGER not null," +
            "FoodSales INTEGER not null)";

    public Database(@Nullable Context context) {
        super(context, "sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
        sqLiteDatabase.execSQL(CREATE_TABLE_TRANSACTIONS);
        sqLiteDatabase.execSQL(CREATE_TABLE_FOODS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Transactions");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Food");
    }
}
