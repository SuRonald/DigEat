package com.example.digeat.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.digeat.R;
import com.example.digeat.helper.TransactionHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.digeat.databases.DataVault.currentUser;

public class CustomerOrderPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Intent movePage;
    TransactionHelper THelper = new TransactionHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order_page);

        RecyclerView orderRV = findViewById(R.id.orderRV);
        CustomerOrderAdapter customerOrderAdapter = new CustomerOrderAdapter(this);
        customerOrderAdapter.setTransactions(THelper.dbTransactionRead(currentUser));
        orderRV.setAdapter(customerOrderAdapter);
        orderRV.setLayoutManager(new GridLayoutManager(this, 1));

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        Menu menu = bottomNavigationView.getMenu();
        menu.getItem(1).setChecked(true);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    movePage = new Intent(this, CustomerHomePage.class);
                    startActivity(movePage);
                    break;

                case R.id.order:
                    movePage = new Intent(this, CustomerOrderPage.class);
                    startActivity(movePage);
                    break;

                case R.id.menu:
                    movePage = new Intent(this, CustomerMenuPage.class);
                    startActivity(movePage);
                    break;

                case R.id.profile:
                    movePage = new Intent(this, CustomerProfilePage.class);
                    startActivity(movePage);
                    break;
            }
            return true;
        });
    }
}