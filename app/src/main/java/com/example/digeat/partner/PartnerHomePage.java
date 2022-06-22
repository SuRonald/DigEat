package com.example.digeat.partner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digeat.R;
import com.example.digeat.helper.TransactionHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.digeat.databases.DataVault.currentUser;

public class PartnerHomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Intent movePage;
    TextView totalIncome;
    TransactionHelper THelper = new TransactionHelper(this);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    String date;
    int income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_home_page);

        date = simpleDateFormat.format(new Date());
        income = THelper.takeIncome(date);
        totalIncome = findViewById(R.id.totalIncome);
        totalIncome.setText("" + income);

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