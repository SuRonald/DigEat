package com.example.digeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.digeat.customer.CustomerHomePage;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    Intent movePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loginBtn){
            movePage = new Intent(this, CustomerHomePage.class);
            startActivity(movePage);
        }
    }
}