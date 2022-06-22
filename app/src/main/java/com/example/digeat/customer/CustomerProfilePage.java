package com.example.digeat.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.digeat.LoginPage;
import com.example.digeat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import static com.example.digeat.databases.DataVault.currentUser;

public class CustomerProfilePage extends AppCompatActivity implements View.OnClickListener{

    BottomNavigationView bottomNavigationView;
    Intent movePage;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile_page);

        btnLogout = findViewById(R.id.buttonLogout);
        btnLogout.setOnClickListener(this);
        bottomNavigationView = findViewById(R.id.bottomNavbar);
        Menu menu = bottomNavigationView.getMenu();
        menu.getItem(3).setChecked(true);
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
        if (view.getId() ==  R.id.buttonLogout){
            currentUser = null;
            movePage = new Intent(this, LoginPage.class);
            startActivity(movePage);
        }
    }
}