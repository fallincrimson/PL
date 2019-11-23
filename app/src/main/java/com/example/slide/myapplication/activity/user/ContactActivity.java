package com.example.slide.myapplication.activity.user;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.slide.myapplication.activity.admin.LoginActivity;
import com.example.slide.myapplication.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button btnAdmin = findViewById(R.id.btn_admin);
        btnAdmin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ContactActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
