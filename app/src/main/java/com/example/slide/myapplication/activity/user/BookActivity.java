package com.example.slide.myapplication.activity.user;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.slide.myapplication.R;
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

import static com.example.slide.myapplication.network.ConfigUrl.DATA_BUKU;

public class BookActivity extends AppCompatActivity {
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

        getData(DATA_BUKU);
    }

    private void getData(String listBuku) {
        Routes client = NetworkClient.getClient().create(Routes.class);
        Call<DataBuku> call = client.getFild(listBuku);
        call.enqueue(new Callback<DataBuku>() {
            @Override
            public void onResponse(Call<DataBuku> call, Response<DataBuku> response) {
                if (response.isSuccessful()) {
                    databaseReference.child(listBuku).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            dataBukus = new ArrayList<>();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                DataBuku dataBuku = dataSnapshot1.getValue(DataBuku.class);
                                dataBukus.add(dataBuku);
                            }
                            bookAdapter = new BookAdapter();
                            recyclerView.setAdapter(bookAdapter);
                            bookAdapter.setMovieList(getApplicationContext(), dataBukus);
                            bookAdapter.setOnItemClickCallback(data -> {
                                Toast.makeText(BookActivity.this, data.getNamaBuku(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(BookActivity.this, DetailBookActivity.class);
                                intent.putExtra("namaBuku", data.getNamaBuku());
                                intent.putExtra("noPanggil", data.getNoPanggil());
                                intent.putExtra("pengarang", data.getPengarang());
                                intent.putExtra("penerbit", data.getPenerbit());
                                intent.putExtra("deskripsi", data.getDeskripsi());
                                intent.putExtra("subjek", data.getSubjek());
                                intent.putExtra("kontendigital", data.getKontenDigital());
                                intent.putExtra("eksemplar", data.getEksemplar());
                                startActivity(intent);
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
}
