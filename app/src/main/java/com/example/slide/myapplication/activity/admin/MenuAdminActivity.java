package com.example.slide.myapplication.activity.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.slide.myapplication.R;
import com.example.slide.myapplication.activity.user.BookActivity;

import static com.example.slide.myapplication.activity.user.BookActivity.MODE_ADMIN;

public class MenuAdminActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAddBook, btnBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        btnAddBook = findViewById(R.id.btn_add_book);
        btnBookList = findViewById(R.id.btn_book_list);

        btnAddBook.setOnClickListener(this);
        btnBookList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_add_book:
                Toast.makeText(this, "Tambah Buku", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, FormIsiBukuActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_book_list:
                Toast.makeText(this, "List Buku", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, BookActivity.class);
                intent.putExtra(MODE_ADMIN, "admin");
                startActivity(intent);
                break;
        }
    }
}
