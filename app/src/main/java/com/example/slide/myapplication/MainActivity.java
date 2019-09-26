package com.example.slide.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView about, book, news, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about = (CardView) findViewById(R.id.about);
        book = (CardView) findViewById(R.id.book);
        news = (CardView) findViewById(R.id.information);
        contact = (CardView) findViewById(R.id.contact);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                Toast.makeText(MainActivity.this, "Introduction", Toast.LENGTH_SHORT).show();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BookActivity.class));
                Toast.makeText(MainActivity.this, "Buku", Toast.LENGTH_SHORT).show();
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InformationActivity.class));
                Toast.makeText(MainActivity.this, "Informasi", Toast.LENGTH_SHORT).show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactActivity.class));
                Toast.makeText(MainActivity.this, "Kontak", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onClick(View view) {

    }
}
