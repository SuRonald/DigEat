package com.example.digeat.partner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.digeat.R;
import com.example.digeat.helper.FoodHelper;
import com.example.digeat.model.Food;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Vector;

public class PartnerAnalyticsPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Intent movePage;
    FoodHelper FHelper = new FoodHelper(this);
    Vector<Food> tempFood = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_analytics_page);

        tempFood = FHelper.dbFoodRead();
        PieChart pieChart = findViewById(R.id.pieChart);
        ArrayList foodParam = new ArrayList();
        foodParam.add(new Entry(tempFood.get(0).getFoodSales(), 0));
        foodParam.add(new Entry(tempFood.get(1).getFoodSales(), 1));
        foodParam.add(new Entry(tempFood.get(2).getFoodSales(), 2));
        foodParam.add(new Entry(tempFood.get(3).getFoodSales(), 3));
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