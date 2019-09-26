package com.example.slide.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash1 extends AppCompatActivity {
    private int waktu_loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(splash1.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}
