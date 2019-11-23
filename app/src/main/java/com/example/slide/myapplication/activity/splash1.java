package com.example.slide.myapplication.activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.slide.myapplication.R;

public class splash1 extends AppCompatActivity {
    private int waktu_loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        new Handler().postDelayed(() -> {

            Intent home=new Intent(splash1.this, MainActivity.class);
            startActivity(home);
            finish();

        },waktu_loading);
    }
}
