package com.example.slide.myapplication.activity.admin;

import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.slide.myapplication.R;
import com.example.slide.myapplication.model.DataBuku;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.slide.myapplication.model.DataTemp.DESKRIPSI;
import static com.example.slide.myapplication.model.DataTemp.EKSEMPLAR;
import static com.example.slide.myapplication.model.DataTemp.KONTEN_DIGITAL;
import static com.example.slide.myapplication.model.DataTemp.NAMA_BUKU;
import static com.example.slide.myapplication.model.DataTemp.NO_PANGGIL;
import static com.example.slide.myapplication.model.DataTemp.PENERBIT;
import static com.example.slide.myapplication.model.DataTemp.PENGARANG;
import static com.example.slide.myapplication.model.DataTemp.SUBJEK;
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
    public static final String MODE_EDIT = "extra_edit";
    private String status;

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
        status = getIntent().getStringExtra(MODE_EDIT);

        if (status != null && status.equalsIgnoreCase("edit")){
            inJudulBuku.setText(getIntent().getStringExtra(NAMA_BUKU));
            inNoPanggil.setText(getIntent().getStringExtra(NO_PANGGIL));
            inPengarang.setText(getIntent().getStringExtra(PENGARANG));
            inPenerbit.setText(getIntent().getStringExtra(PENERBIT));
            inDeskripsi.setText(getIntent().getStringExtra(DESKRIPSI));
            inSubjek.setText(getIntent().getStringExtra(SUBJEK));
            inKontenDigital.setText(getIntent().getStringExtra(KONTEN_DIGITAL));
            inEksemplar.setText(getIntent().getStringExtra(EKSEMPLAR));
        }

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
            Snackbar.make(findViewById(R.id.simpan), "Data Kosong", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void submitMenu(DataBuku dataBuku) {
        database.child(pathBuku)
                .push()
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
