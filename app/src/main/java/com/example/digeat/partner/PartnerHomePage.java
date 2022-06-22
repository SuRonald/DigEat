package com.example.digeat.partner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.digeat.R;
import com.example.digeat.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PartnerHomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Intent movePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_home_page);

        User user = getIntent().getParcelableExtra("user");

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        Menu menu = bottomNavigationView.getMenu();
        menu.getItem(0).setChecked(true);
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
}