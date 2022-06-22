package com.example.digeat.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.digeat.databases.Database;
import com.example.digeat.model.Transactions;
import com.example.digeat.model.User;

import java.util.Vector;

public class TransactionHelper {

    private final String TABLE_NAME = "Transactions";
    private Database databases;
    private SQLiteDatabase db;

    public TransactionHelper(Context context){
        databases = new Database(context);
    }

    // insert
    public void dbTransactionInsert(Transactions transactions){
        db = databases.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CustomerID", transactions.getCustomerId());
        contentValues.put("Date", transactions.getTransactionDate());
        contentValues.put("TotalPrice", transactions.getTotalPrice());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    //read
    public Vector<Transactions> dbTransactionRead(User user){
        db = databases.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Transactions WHERE CustomerID = ?", new String[]{user.getUserId().toString()});
        cursor.moveToFirst();

        Vector<Transactions> temp = new Vector<>();
        Integer transactionId, customerId, totalPrice;
        String transactionDate;

        if (cursor != null && cursor.getCount() > 0){
            do {
                transactionId = cursor.getInt(cursor.getColumnIndexOrThrow("TransactionID"));
                transactionDate = cursor.getString(cursor.getColumnIndexOrThrow("Date"));
                customerId = cursor.getInt(cursor.getColumnIndexOrThrow("CustomerID"));
                totalPrice = cursor.getInt(cursor.getColumnIndexOrThrow("TotalPrice"));

                temp.add(new Transactions(transactionId, customerId, totalPrice, transactionDate));

                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        db.close();
        return temp;
    }

    public int takeIncome(String date){
        db = databases.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Transactions WHERE Date LIKE ?", new String[]{date});
        cursor.moveToFirst();

        int temp = 0;

        if (cursor != null && cursor.getCount() > 0){
            do {
                temp = temp + cursor.getInt(cursor.getColumnIndexOrThrow("TotalPrice"));
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        db.close();
        return temp;
    }
}
