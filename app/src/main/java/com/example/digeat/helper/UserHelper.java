package com.example.digeat.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.digeat.databases.Database;
import com.example.digeat.model.User;

public class UserHelper {

    private final String TABLE_NAME = "User";
    private Database databases;
    private SQLiteDatabase db;

    public UserHelper(Context context){
        databases = new Database(context);
    }

    // insert
    public void dbUserInsert(User user){
        db = databases.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserName", user.getUserName());
        contentValues.put("UserEmailAddress", user.getUserEmail());
        contentValues.put("UserPassword", user.getUserPass());
        contentValues.put("UserType", user.getUserType());
        contentValues.put("UserWallet", user.getUserWallet());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    //read
    public User dbUserRead(String email, String password){
        db = databases.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User WHERE UserEmailAddress = ? and UserPassword = ?",
                new String[]{email, password});
        User user = null;
        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            user = new User();
            user.setUserId(cursor.getInt(0));
            user.setUserName(cursor.getString(1));
            user.setUserEmail(cursor.getString(2));
            user.setUserPass(cursor.getString(3));
            user.setUserType(cursor.getInt(4));
            user.setUserWallet(cursor.getInt(5));
            cursor.close();
        }
        db.close();
        return user;
    }

    //updateWallet
    public void dbUpdateWallet(User user, Integer payment){
        db = databases.getWritableDatabase();
        Integer wallet = user.getUserWallet() - payment;
        if (wallet < 0){
            wallet = 0;
        }
        ContentValues cv = new ContentValues();
        cv.put("UserWallet", wallet);
        db.update(TABLE_NAME, cv, "UserID = ?", new String[]{user.getUserId().toString()});
        db.close();
    }

}
