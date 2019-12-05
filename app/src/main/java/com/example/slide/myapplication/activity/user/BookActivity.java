package com.example.slide.myapplication.activity.user;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.slide.myapplication.R;
import com.example.slide.myapplication.activity.admin.FormIsiBukuActivity;
import com.example.slide.myapplication.activity.user.subdatabook.DetailBookActivity;
import com.example.slide.myapplication.adapter.BookAdapter;
import com.example.slide.myapplication.model.DataBuku;
import com.example.slide.myapplication.network.NetworkClient;
import com.example.slide.myapplication.network.Routes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.slide.myapplication.activity.admin.FormIsiBukuActivity.MODE_EDIT;
import static com.example.slide.myapplication.model.DataTemp.DESKRIPSI;
import static com.example.slide.myapplication.model.DataTemp.EKSEMPLAR;
import static com.example.slide.myapplication.model.DataTemp.KONTEN_DIGITAL;
import static com.example.slide.myapplication.model.DataTemp.NAMA_BUKU;
import static com.example.slide.myapplication.model.DataTemp.NO_PANGGIL;
import static com.example.slide.myapplication.model.DataTemp.PENERBIT;
import static com.example.slide.myapplication.model.DataTemp.PENGARANG;
import static com.example.slide.myapplication.model.DataTemp.SUBJEK;
import static com.example.slide.myapplication.network.ConfigUrl.DATA_BUKU;

public class BookActivity extends AppCompatActivity {

    public static final String MODE_ADMIN = "extra_note";
    private String status;
    TextView btnEdit, btnHapus, titleDialog;

    private SearchView searchView;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    private BookAdapter bookAdapter;
    private DatabaseReference databaseReference;
    private ArrayList<DataBuku> dataBukus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        recyclerView = findViewById(R.id.list_book);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        status = getIntent().getStringExtra(MODE_ADMIN);

        getData(DATA_BUKU);
    }

    private void getData(String listBuku) {
        Routes client = NetworkClient.getClient().create(Routes.class);
        Call<DataBuku> call = client.getFild(listBuku);
        call.enqueue(new Callback<DataBuku>() {
            @Override
            public void onResponse(Call<DataBuku> call, Response<DataBuku> response) {
                if (response.isSuccessful()) {
                    databaseReference.child(listBuku).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            dataBukus = new ArrayList<>();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                DataBuku dataBuku = dataSnapshot1.getValue(DataBuku.class);
                                dataSnapshot1.getRef().getKey();
                                dataSnapshot1.getKey();
                                dataBukus.add(dataBuku);
                            }
                            bookAdapter = new BookAdapter();
                            recyclerView.setAdapter(bookAdapter);
                            bookAdapter.setMovieList(getApplicationContext(), dataBukus);
                            bookAdapter.setOnItemClickCallback(data -> {
                                if (status != null && status.equalsIgnoreCase("admin")) {
                                    showDialog(data);
                                } else {
                                    Toast.makeText(BookActivity.this, data.getNamaBuku(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(BookActivity.this, DetailBookActivity.class);
                                    intent.putExtra(NAMA_BUKU, data.getNamaBuku());
                                    intent.putExtra(NO_PANGGIL, data.getNoPanggil());
                                    intent.putExtra(PENGARANG, data.getPengarang());
                                    intent.putExtra(PENERBIT, data.getPenerbit());
                                    intent.putExtra(DESKRIPSI, data.getDeskripsi());
                                    intent.putExtra(SUBJEK, data.getSubjek());
                                    intent.putExtra(KONTEN_DIGITAL, data.getKontenDigital());
                                    intent.putExtra(EKSEMPLAR, data.getEksemplar());
                                    startActivity(intent);
                                }
                            });

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<DataBuku> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                bookAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                bookAdapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("CutPasteId")
    private void showDialog(DataBuku data) {
        Toast.makeText(BookActivity.this, data.getNamaBuku(), Toast.LENGTH_SHORT).show();
        View mDialogView = LayoutInflater.from(this).inflate(R.layout.item_dialog, null);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this)
                .setView(mDialogView);

        AlertDialog mAlertDialog = mBuilder.show();
        titleDialog = mAlertDialog.findViewById(R.id.title_dialog);
        btnEdit = mAlertDialog.findViewById(R.id.btn_edit);
        btnHapus = mAlertDialog.findViewById(R.id.btn_hapus);

        titleDialog.setText(data.getNamaBuku());

        btnEdit.setOnClickListener(view ->
                moveToIntent(data)
        );

        btnHapus.setOnClickListener(view ->
                Toast.makeText(BookActivity.this, "Hapus", Toast.LENGTH_SHORT).show()
        );
    }

    private void moveToIntent(DataBuku data) {
        Toast.makeText(BookActivity.this, "Edit", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(BookActivity.this, FormIsiBukuActivity.class);
        intent.putExtra(MODE_EDIT, "edit");
        intent.putExtra(NAMA_BUKU, data.getNamaBuku());
        intent.putExtra(NO_PANGGIL, data.getNoPanggil());
        intent.putExtra(PENGARANG, data.getPengarang());
        intent.putExtra(PENERBIT, data.getPenerbit());
        intent.putExtra(DESKRIPSI, data.getDeskripsi());
        intent.putExtra(SUBJEK, data.getSubjek());
        intent.putExtra(KONTEN_DIGITAL, data.getKontenDigital());
        intent.putExtra(EKSEMPLAR, data.getEksemplar());
        startActivity(intent);
    }

}
