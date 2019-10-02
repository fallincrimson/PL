package com.example.slide.myapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.slide.myapplication.R;

public class SplashActivity extends AppCompatActivity {
    private int waktu_loading2 = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {

            Intent home=new Intent(SplashActivity.this, MainActivity.class);
            startActivity(home);
            finish();

        },waktu_loading2);
    }
}
