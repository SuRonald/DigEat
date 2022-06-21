package com.example.digeat.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.digeat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.ibrahimsn.lib.SmoothBottomBar;

public class CustomerHomePage extends AppCompatActivity implements View.OnClickListener {

    SmoothBottomBar bottomNavigationView;
    Intent movePage;
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_page);

        orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(this);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item){
                case 0:
                    movePage = new Intent(this, CustomerHomePage.class);
                    startActivity(movePage);
                    break;

                case 1:
                    movePage = new Intent(this, CustomerOrderPage.class);
                    startActivity(movePage);
                    break;

                case 2:
                    movePage = new Intent(this, CustomerMenuPage.class);
                    startActivity(movePage);
                    break;

                case 3:
                    movePage = new Intent(this, CustomerProfilePage.class);
                    startActivity(movePage);
                    break;
            }
            return true;
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() ==  R.id.orderBtn){
            movePage = new Intent(this, CustomerQRScan.class);
            startActivity(movePage);
        }
    }
}