package com.example.digeat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digeat.customer.CustomerHomePage;
import com.example.digeat.helper.UserHelper;
import com.example.digeat.model.User;
import com.example.digeat.partner.PartnerHomePage;

import static com.example.digeat.databases.DataVault.currentUser;

public class LoginPage extends AppCompatActivity {

    EditText insEmail, insPassword;
    TextView redRegist;
    Button loginBtn;

    UserHelper userHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        init();

        userHelper = new UserHelper(this);

        redRegist.setOnClickListener(view -> {
            Intent moveRegist = new Intent(this, RegisterPage.class);
            startActivity(moveRegist);
        });

        loginBtn.setOnClickListener(view -> {
            String email = insEmail.getText().toString();
            String password = insPassword.getText().toString();
            Integer type;

            User user = userHelper.dbUserRead(email, password);

            if (email.length() == 0){
                insEmail.setError("This field must be filled!");
            }
            else if (password.length() == 0){
                insPassword.setError("This field must be filled!");
            }
            else {
                if (user == null){
                    insEmail.setError("This email hasn't registered yet!");;
                }
                else if (user != null) {
                    type = user.getUserType();

                    if (type == 1){
                        Intent goHome = new Intent(this, CustomerHomePage.class);
                        currentUser = user;
                        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        this.finish();
                        startActivity(goHome);
                    }
                    else if (type == 2){
                        Intent goHome = new Intent(this, PartnerHomePage.class);
                        currentUser = user;
                        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        this.finish();
                        startActivity(goHome);
                    }
                }
            }
        });
    }

    public void init(){
        insEmail = findViewById(R.id.inputEmail);
        insPassword = findViewById(R.id.inputPassword);

        redRegist = findViewById(R.id.signupRe);
        loginBtn = findViewById(R.id.loginBtn);
    }
}