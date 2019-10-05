package com.example.slide.myapplication.activity.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slide.myapplication.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    String user = "admin";
    String pass = "admin321";
    EditText inUser, inPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inUser = findViewById(R.id.user);
        inPass = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String inputUser = inUser.getText().toString().trim();
        String inputPass = inPass.getText().toString().trim();

        boolean isEmptyField = false;

        if (TextUtils.isEmpty(inputUser)) {
            isEmptyField = true;
            inPass.setError("Username Kosong");
        }
        if (TextUtils.isEmpty(inputPass)) {
            isEmptyField = true;
            inPass.setError("Password Kosong");
        }

        if (!isEmptyField) {
            if (inputUser.equals(user) && inputPass.equals(pass)) {
                Toast.makeText(this, "Mode Admin", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, FormIsiBukuActivity.class);
                startActivity(intent);
            }
        }
    }
}
