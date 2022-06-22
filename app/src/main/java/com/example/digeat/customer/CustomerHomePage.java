package com.example.digeat.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digeat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.digeat.databases.DataVault.currentUser;

public class CustomerHomePage extends AppCompatActivity implements View.OnClickListener {

    BottomNavigationView bottomNavigationView;
    Intent movePage;
    Button orderBtn;
    TextView viewMap, userWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_page);

        userWallet = findViewById(R.id.userWallet);
        userWallet.setText("" + currentUser.getUserWallet());

        viewMap = findViewById(R.id.viewMap);
        viewMap.setOnClickListener(this);
        orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(this);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        Menu menu = bottomNavigationView.getMenu();
        menu.getItem(0).setChecked(true);
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

    @Override
    public void onClick(View view) {
        if (view.getId() ==  R.id.orderBtn){
            movePage = new Intent(this, CustomerQRScan.class);
            startActivity(movePage);
        }
        else if (view.getId() == R.id.viewMap){
            movePage = new Intent(this, CustomerMapPage.class);
            startActivity(movePage);
        }
    }
}