package com.example.slide.myapplication.activity.user.subdatabook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.slide.myapplication.R;

public class DetailBookActivity extends AppCompatActivity {
    TextView namaBuku, noPanggil, pengarang, penerbit, deskripsi, subjek, kontenDigital, eksemplar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        namaBuku = findViewById(R.id.nama_buku);
        noPanggil = findViewById(R.id.no_panggil);
        pengarang = findViewById(R.id.nama_pengarang);
        penerbit = findViewById(R.id.nama_penerbit);
        deskripsi = findViewById(R.id.nama_deskripsi);
        subjek = findViewById(R.id.nama_subjek);
        kontenDigital = findViewById(R.id.nama_digital);
        eksemplar = findViewById(R.id.nama_eksemplar);

        namaBuku.setText(getIntent().getStringExtra("namaBuku"));
        noPanggil.setText(getIntent().getStringExtra("noPanggil"));
        pengarang.setText(getIntent().getStringExtra("pengarang"));
        penerbit.setText(getIntent().getStringExtra("penerbit"));
        deskripsi.setText(getIntent().getStringExtra("deskripsi"));
        subjek.setText(getIntent().getStringExtra("subjek"));
        kontenDigital.setText(getIntent().getStringExtra("kontendigital"));
        eksemplar.setText(getIntent().getStringExtra("eksemplar"));
    }
}
