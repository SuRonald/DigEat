package com.example.digeat.partner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.digeat.LoginPage;
import com.example.digeat.R;
import com.example.digeat.customer.CustomerQRScan;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import static com.example.digeat.databases.DataVault.currentUser;

public class PartnerProfilePage extends AppCompatActivity implements View.OnClickListener{

    BottomNavigationView bottomNavigationView;
    Intent movePage;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_profile_page);

        btnLogout = findViewById(R.id.buttonLogout);
        btnLogout.setOnClickListener(this);
        bottomNavigationView = findViewById(R.id.bottomNavbar);
        Menu menu = bottomNavigationView.getMenu();
        menu.getItem(3).setChecked(true);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    movePage = new Intent(this, PartnerHomePage.class);
                    startActivity(movePage);
                    break;

                case R.id.analytics:
                    movePage = new Intent(this, PartnerAnalyticsPage.class);
                    startActivity(movePage);
                    break;

                case R.id.showqr:
                    movePage = new Intent(this, PartnerShowQRPage.class);
                    startActivity(movePage);
                    break;

                case R.id.profile:
                    movePage = new Intent(this, PartnerProfilePage.class);
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