package com.example.digeat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digeat.helper.FoodHelper;
import com.example.digeat.helper.UserHelper;
import com.example.digeat.model.Food;
import com.example.digeat.model.User;

public class RegisterPage extends AppCompatActivity {

    ImageView selectCust, selectedCust, selectPart, selectedPart, btnBack;
    EditText insEmail, insName, insPassword, confPassword;
    Button btnRegist;

    Integer userType = 0, flag = 1;

    Food food;
    UserHelper userHelper; FoodHelper foodHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        init();

        userHelper = new UserHelper(this);
        foodHelper = new FoodHelper(this);

        btnBack.setOnClickListener(view -> {
            onBackPressed();
        });

        selectCust.setOnClickListener(view -> {
            if (selectCust.getVisibility() == View.VISIBLE && selectPart.getVisibility() == View.VISIBLE){
                selectCust.setVisibility(View.INVISIBLE);
                selectedCust.setVisibility(View.VISIBLE);
                userType = 1;
            }
            else if (selectedCust.getVisibility() == View.VISIBLE && selectPart.getVisibility() == View.VISIBLE){
                selectCust.setVisibility(View.VISIBLE);
                selectedCust.setVisibility(View.INVISIBLE);
                userType = 0;
            }
            else if (selectCust.getVisibility() == View.VISIBLE && selectedPart.getVisibility() == View.VISIBLE){
                selectCust.setVisibility(View.INVISIBLE); selectPart.setVisibility(View.VISIBLE);
                selectedCust.setVisibility(View.VISIBLE); selectedPart.setVisibility(View.INVISIBLE);
                userType = 1;
            }
        });

        selectPart.setOnClickListener(view -> {
            if (selectPart.getVisibility() == View.VISIBLE && selectCust.getVisibility() == View.VISIBLE){
                selectPart.setVisibility(View.INVISIBLE);
                selectedPart.setVisibility(View.VISIBLE);
                userType = 2;
            }
            else if (selectedPart.getVisibility() == View.VISIBLE && selectCust.getVisibility() == View.VISIBLE){
                selectPart.setVisibility(View.VISIBLE);
                selectedPart.setVisibility(View.INVISIBLE);
                userType = 0;
            }
            else if (selectPart.getVisibility() == View.VISIBLE && selectedCust.getVisibility() == View.VISIBLE){
                selectPart.setVisibility(View.INVISIBLE); selectCust.setVisibility(View.VISIBLE);
                selectedPart.setVisibility(View.VISIBLE); selectedCust.setVisibility(View.INVISIBLE);
                userType = 2;
            }
        });

        btnRegist.setOnClickListener(view -> {
            String email = insEmail.getText().toString();
            String name = insName.getText().toString();
            String pass = insPassword.getText().toString();
            String confPass = confPassword.getText().toString();

            if (email.length() == 0){
                insEmail.setError("This field must be filled!");
            }
            else if (name.length() == 0){
                insName.setError("This field must be filled!");
            }
            else if (pass.length() == 0){
                insPassword.setError("This field must be filled!");
            }
            else if (confPass.length() == 0){
                confPassword.setError("This field must be filled!");
            }
            else {
                if (!confPass.equals(pass)){
                    confPassword.setError("Password doesn't match!");
                    flag = 0;
                }
                if (flag == 1){
                    if (userType == 0){
                        Toast.makeText(this, "Please select your role!", Toast.LENGTH_SHORT).show();
                    }
                    else if (userType == 1 || userType == 2) {
                        foodHelper.dbFoodClear();
                        food = new Food(R.drawable.nasi_uduk, "Nasi Uduk", 25000, 1, 0);
                        foodHelper.dbFoodInsert(food);
                        food = new Food(R.drawable.ayam_goreng, "Ayam Goreng", 6000, 2, 0);
                        foodHelper.dbFoodInsert(food);
                        food = new Food(R.drawable.sayur_asem, "Sayur Asem", 5000, 3, 0);
                        foodHelper.dbFoodInsert(food);
                        food = new Food(R.drawable.ikan_pepes, "Ikan Pepes", 6500, 4, 0);
                        foodHelper.dbFoodInsert(food);

                        User user = new User(userType, 800000, name, pass, email);
                        userHelper.dbUserInsert(user);
                        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show();
                        this.finish();
                    }
                }
            }

        });

    }

    public void init(){
        insEmail = findViewById(R.id.inputEmail);
        insName = findViewById(R.id.inputName);
        insPassword = findViewById(R.id.inputPassword);
        confPassword = findViewById(R.id.inputConfirmPassword);

        selectCust = findViewById(R.id.custSelect);
        selectedCust = findViewById(R.id.custSelected);
        selectPart = findViewById(R.id.partSelect);
        selectedPart = findViewById(R.id.partSelected);

        btnRegist = findViewById(R.id.RegisBtn);
        btnBack = findViewById(R.id.backBtn);
    }
}