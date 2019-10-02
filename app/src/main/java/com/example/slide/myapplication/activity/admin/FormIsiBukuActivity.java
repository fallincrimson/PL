package com.example.slide.myapplication.activity.admin;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.slide.myapplication.R;
import com.example.slide.myapplication.model.DataBuku;
import com.example.slide.myapplication.model.DataTemp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.slide.myapplication.model.DataTemp.deskripsi;
import static com.example.slide.myapplication.model.DataTemp.eksemplar;
import static com.example.slide.myapplication.model.DataTemp.kontenDigital;
import static com.example.slide.myapplication.model.DataTemp.namaBuku;
import static com.example.slide.myapplication.model.DataTemp.noPanggil;
import static com.example.slide.myapplication.model.DataTemp.pathBuku;
import static com.example.slide.myapplication.model.DataTemp.penerbit;
import static com.example.slide.myapplication.model.DataTemp.pengarang;
import static com.example.slide.myapplication.model.DataTemp.subjek;

public class FormIsiBukuActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference database;

    EditText inJudulBuku, inNoPanggil, inPengarang, inPenerbit, inDeskripsi, inSubjek, inKontenDigital, inEksemplar;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_isi_buku);

        inJudulBuku = findViewById(R.id.judul_buku);
        inNoPanggil = findViewById(R.id.no_panggil);
        inPengarang = findViewById(R.id.pengarang_buku);
        inPenerbit = findViewById(R.id.penerbit_buku);
        inDeskripsi = findViewById(R.id.deskripsi_buku);
        inSubjek = findViewById(R.id.subjek_buku);
        inKontenDigital = findViewById(R.id.konten_digital_buku);
        inEksemplar = findViewById(R.id.eksemplar_buku);
        btnSimpan = findViewById(R.id.simpan);

        database = FirebaseDatabase.getInstance().getReference();
        btnSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        namaBuku = inJudulBuku.getText().toString();
        noPanggil = inNoPanggil.getText().toString();
        pengarang = inPengarang.getText().toString();
        penerbit = inPenerbit.getText().toString();
        deskripsi = inDeskripsi.getText().toString();
        subjek = inSubjek.getText().toString();
        kontenDigital = inKontenDigital.getText().toString();
        eksemplar = inEksemplar.getText().toString();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(namaBuku)) {
            isEmptyFields = true;
            inJudulBuku.setError("silahakan Diisi");
        }
        if (TextUtils.isEmpty(noPanggil)) {
            isEmptyFields = true;
            inNoPanggil.setError("silahakan Diisi");
        }
        if (TextUtils.isEmpty(pengarang)) {
            isEmptyFields = true;
            inPengarang.setError("silahakan Diisi");
        }
        if (TextUtils.isEmpty(penerbit)) {
            isEmptyFields = true;
            inPenerbit.setError("silahakan Diisi");
        }
        if (TextUtils.isEmpty(deskripsi)) {
            isEmptyFields = true;
            inDeskripsi.setError("silahakan Diisi");
        }
        if (TextUtils.isEmpty(subjek)) {
            isEmptyFields = true;
            inSubjek.setError("silahakan Diisi");
        }
        if (TextUtils.isEmpty(kontenDigital)) {
            isEmptyFields = true;
            inKontenDigital.setError("silahakan Diisi");
        }
        if (TextUtils.isEmpty(eksemplar)) {
            isEmptyFields = true;
            inEksemplar.setError("silahakan Diisi");
        }

        if (!isEmptyFields) {
            submitMenu(new DataBuku(
                    namaBuku,
                    noPanggil,
                    pengarang,
                    penerbit,
                    deskripsi,
                    subjek,
                    kontenDigital,
                    eksemplar
            ));
        } else {
            Snackbar.make(findViewById(R.id.simpan), "Data berhasil disimpan", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void submitMenu(DataBuku dataBuku) {
        database.child(pathBuku)
                .child(noPanggil)
                .setValue(dataBuku)
                .addOnSuccessListener(this, data -> {
                    inJudulBuku.setText("");
                    inNoPanggil.setText("");
                    inPengarang.setText("");
                    inPenerbit.setText("");
                    inDeskripsi.setText("");
                    inSubjek.setText("");
                    inKontenDigital.setText("");
                    inEksemplar.setText("");
                    Snackbar.make(findViewById(R.id.simpan), "Data berhasil disimpan", Snackbar.LENGTH_SHORT).show();
                });
    }
}
