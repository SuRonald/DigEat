package com.example.digeat.partner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.digeat.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PartnerAnalyticsPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Intent movePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_analytics_page);

        PieChart pieChart = findViewById(R.id.pieChart);
        ArrayList foodParam = new ArrayList();
        foodParam.add(new Entry(1, 0));
        foodParam.add(new Entry(2, 1));
        foodParam.add(new Entry(3, 2));
        foodParam.add(new Entry(4, 3));
        PieDataSet dataSet = new PieDataSet(foodParam, "");

        ArrayList foodName = new ArrayList();
        foodName.add("Nasi Uduk");
        foodName.add("Ayam Goreng");
        foodName.add("Sayur Asem");
        foodName.add("Ikan Pepes");
        PieData data = new PieData(foodName, dataSet);
        pieChart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(3000, 3000);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        Menu menu = bottomNavigationView.getMenu();
        menu.getItem(1).setChecked(true);
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