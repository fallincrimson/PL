package com.example.slide.myapplication.activity.user.subdatabook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.slide.myapplication.R;

import static com.example.slide.myapplication.model.DataTemp.DESKRIPSI;
import static com.example.slide.myapplication.model.DataTemp.EKSEMPLAR;
import static com.example.slide.myapplication.model.DataTemp.KONTEN_DIGITAL;
import static com.example.slide.myapplication.model.DataTemp.NAMA_BUKU;
import static com.example.slide.myapplication.model.DataTemp.NO_PANGGIL;
import static com.example.slide.myapplication.model.DataTemp.PENERBIT;
import static com.example.slide.myapplication.model.DataTemp.PENGARANG;
import static com.example.slide.myapplication.model.DataTemp.SUBJEK;

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

        namaBuku.setText(getIntent().getStringExtra(NAMA_BUKU));
        noPanggil.setText(getIntent().getStringExtra(NO_PANGGIL));
        pengarang.setText(getIntent().getStringExtra(PENGARANG));
        penerbit.setText(getIntent().getStringExtra(PENERBIT));
        deskripsi.setText(getIntent().getStringExtra(DESKRIPSI));
        subjek.setText(getIntent().getStringExtra(SUBJEK));
        kontenDigital.setText(getIntent().getStringExtra(KONTEN_DIGITAL));
        eksemplar.setText(getIntent().getStringExtra(EKSEMPLAR));
    }
}
