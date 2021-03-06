package com.example.digeat.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.digeat.R;
import com.example.digeat.helper.FoodHelper;
import com.example.digeat.helper.TransactionHelper;
import com.example.digeat.helper.UserHelper;
import com.example.digeat.model.Food;
import com.example.digeat.model.Transactions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import static com.example.digeat.databases.DataVault.currentUser;

public class CustomerOrderingPage extends AppCompatActivity implements View.OnClickListener {

    ImageView backBtn;
    CardView deductBtnP1, deductBtnP2, deductBtnP3, deductBtnP4;
    CardView addBtnP1, addBtnP2, addBtnP3, addBtnP4;
    CardView lightHouse, confirmDialog;
    TextView countP1, countP2, countP3, countP4, totalPrice, errMsg;
    Button orderBtn, okBtn;
    Intent movePage;
    int[] prices = {25000, 6000, 5000, 6500};
    int[] qnty = {0, 0, 0, 0};
    int ttlPrice = 0;

    TransactionHelper transactionHelper = new TransactionHelper(this);
    FoodHelper FHelper = new FoodHelper(this);
    UserHelper UHelper = new UserHelper(this);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_ordering_page);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        deductBtnP1 = findViewById(R.id.deductBtnP1);
        deductBtnP1.setOnClickListener(this);
        deductBtnP2 = findViewById(R.id.deductBtnP2);
        deductBtnP2.setOnClickListener(this);
        deductBtnP3 = findViewById(R.id.deductBtnP3);
        deductBtnP3.setOnClickListener(this);
        deductBtnP4 = findViewById(R.id.deductBtnP4);
        deductBtnP4.setOnClickListener(this);
        addBtnP1 = findViewById(R.id.addBtnP1);
        addBtnP1.setOnClickListener(this);
        addBtnP2 = findViewById(R.id.addBtnP2);
        addBtnP2.setOnClickListener(this);
        addBtnP3 = findViewById(R.id.addBtnP3);
        addBtnP3.setOnClickListener(this);
        addBtnP4 = findViewById(R.id.addBtnP4);
        addBtnP4.setOnClickListener(this);
        countP1 = findViewById(R.id.countP1);
        countP2 = findViewById(R.id.countP2);
        countP3 = findViewById(R.id.countP3);
        countP4 = findViewById(R.id.countP4);
        errMsg = findViewById(R.id.errMsg);
        totalPrice = findViewById(R.id.totalPrice);
        totalPrice.setText("Rp. 0");
        orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(this);
        lightHouse = findViewById(R.id.lightHouse);
        confirmDialog = findViewById(R.id.confirmDialog);
        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.backBtn){
            movePage = new Intent(this, CustomerHomePage.class);
            startActivity(movePage);
        }
        else if (view.getId() == R.id.deductBtnP1 && qnty[0] != 0){
            ttlPrice = ttlPrice - prices[0];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[0]--;
            countP1.setText("" + qnty[0]);
        }
        else if (view.getId() == R.id.addBtnP1){
            ttlPrice = ttlPrice + prices[0];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[0]++;
            countP1.setText("" + qnty[0]);
        }
        else if (view.getId() == R.id.deductBtnP2 && qnty[1] != 0){
            ttlPrice = ttlPrice - prices[1];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[1]--;
            countP2.setText("" + qnty[1]);
        }
        else if (view.getId() == R.id.addBtnP2){
            ttlPrice = ttlPrice + prices[1];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[1]++;
            countP2.setText("" + qnty[1]);
        }
        else if (view.getId() == R.id.deductBtnP3 && qnty[2] != 0){
            ttlPrice = ttlPrice - prices[2];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[2]--;
            countP3.setText("" + qnty[2]);
        }
        else if (view.getId() == R.id.addBtnP3){
            ttlPrice = ttlPrice + prices[2];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[2]++;
            countP3.setText("" + qnty[2]);
        }
        else if (view.getId() == R.id.deductBtnP4 && qnty[3] != 0){
            ttlPrice = ttlPrice - prices[3];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[3]--;
            countP4.setText("" + qnty[3]);
        }
        else if (view.getId() == R.id.addBtnP4){
            ttlPrice = ttlPrice + prices[3];
            totalPrice.setText("Rp. " + ttlPrice);
            qnty[3]++;
            countP4.setText("" + qnty[3]);
        }
        else if (view.getId() == R.id.orderBtn){
            if (ttlPrice == 0){
                errMsg.setText("Please at least order something! :)");
            }
            else {
                errMsg.setText("");
                lightHouse.setVisibility(View.VISIBLE);
                confirmDialog.setVisibility(View.VISIBLE);
            }
        }
        else if (view.getId() == R.id.okBtn){
            date = simpleDateFormat.format(new Date());
            Transactions transactions = new Transactions(currentUser.getUserId(), ttlPrice, date);
            transactionHelper.dbTransactionInsert(transactions);
            Vector<Food> temp = FHelper.dbFoodRead();
            FHelper.dbAddFoodSales(temp.get(0), qnty[0]);
            FHelper.dbAddFoodSales(temp.get(1), qnty[1]);
            FHelper.dbAddFoodSales(temp.get(2), qnty[2]);
            FHelper.dbAddFoodSales(temp.get(3), qnty[3]);
            UHelper.dbUpdateWallet(currentUser, ttlPrice);
            currentUser.setUserWallet(currentUser.getUserWallet() - ttlPrice);
            movePage = new Intent(this, CustomerHomePage.class);
            startActivity(movePage);
        }
    }
}