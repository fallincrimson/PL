package com.example.slide.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{
    Button  btnSubmit, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnAdmin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
