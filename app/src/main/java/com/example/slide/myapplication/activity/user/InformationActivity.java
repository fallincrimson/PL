package com.example.slide.myapplication.activity.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.slide.myapplication.R;
import com.example.slide.myapplication.activity.user.subinformation.AnggotaActivity;
import com.example.slide.myapplication.activity.user.subinformation.PinjamActivity;
import com.example.slide.myapplication.activity.user.subinformation.PusLingActivity;
import com.example.slide.myapplication.activity.user.subinformation.WisataActivity;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAnggota, btnPinjam, btnPusling, btnWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        btnAnggota = findViewById(R.id.btn_anggota);
        btnPinjam = findViewById(R.id.btn_pinjam);
        btnPusling = findViewById(R.id.btn_pusling);
        btnWisata = findViewById(R.id.btn_wisata);

        btnAnggota.setOnClickListener(this);
        btnPinjam.setOnClickListener(this);
        btnPusling.setOnClickListener(this);
        btnWisata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_anggota) {
            Intent intent = new Intent(InformationActivity.this, AnggotaActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_pinjam) {
            Intent intent = new Intent(InformationActivity.this, PinjamActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_pusling) {
            Intent intent = new Intent(InformationActivity.this, PusLingActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_wisata) {
            Intent intent = new Intent(InformationActivity.this, WisataActivity.class);
            startActivity(intent);
        }
    }
}
