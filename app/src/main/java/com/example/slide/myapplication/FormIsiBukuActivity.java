package com.example.slide.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.slide.myapplication.model.DataBuku;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormIsiBukuActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference database;

    EditText judulBuku, noPanggil,pengarang,penerbit,deskripsi,subjek,kontenDigital,eksemplar;
    Button btnSimpan;
    String judBuku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_isi_buku);
        judulBuku = findViewById(R.id.judul_buku);
        noPanggil = findViewById(R.id.no_panggil);
        pengarang=findViewById(R.id.pengarang_buku);
        penerbit=findViewById(R.id.penerbit_buku);
        deskripsi=findViewById(R.id.deskripsi_buku);
        subjek = findViewById(R.id.subjek_buku);
        kontenDigital = findViewById(R.id.konten_digital_buku);
        eksemplar = findViewById(R.id.eksemplar_buku);
        btnSimpan = findViewById(R.id.simpan);
        judBuku = judulBuku.getText().toString();
        database = FirebaseDatabase.getInstance().getReference();
        btnSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (!isEmpty(judulBuku.getText().toString())){
            submitMenu(new DataBuku(
                    judulBuku.getText().toString(),
                    noPanggil.getText().toString(),
                    pengarang.getText().toString(),
                    penerbit.getText().toString(),
                    deskripsi.getText().toString(),
                    subjek.getText().toString(),
                    kontenDigital.getText().toString(),
                    eksemplar.getText().toString()
            ));
        } else {
            Snackbar.make(findViewById(R.id.simpan), "Data berhasil disimpan", Snackbar.LENGTH_SHORT).show();
        }

    }

    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void submitMenu(DataBuku dataBuku){
        database.child("menu")
                .push()
                .setValue(dataBuku)
                .addOnSuccessListener(this, data ->{
                    judulBuku.setText("");
                    noPanggil.setText("");
                    pengarang.setText("");
                    penerbit.setText("");
                    deskripsi.setText("");
                    subjek.setText("");
                    kontenDigital.setText("");
                    eksemplar.setText("");
                    Snackbar.make(findViewById(R.id.simpan), "Data berhasil disimpan", Snackbar.LENGTH_SHORT).show();
                });
    }
}
