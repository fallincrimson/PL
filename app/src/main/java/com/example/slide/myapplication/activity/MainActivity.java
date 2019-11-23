package com.example.slide.myapplication.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

import com.example.slide.myapplication.R;
import com.example.slide.myapplication.activity.user.AboutActivity;
import com.example.slide.myapplication.activity.user.BookActivity;
import com.example.slide.myapplication.activity.user.ContactActivity;
import com.example.slide.myapplication.activity.user.InformationActivity;


public class MainActivity extends AppCompatActivity{
    CardView about, book, news, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about = findViewById(R.id.about);
        book = findViewById(R.id.book);
        news = findViewById(R.id.information);
        contact = findViewById(R.id.contact);

        about.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));

        book.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BookActivity.class)));

        news.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, InformationActivity.class)));

        contact.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ContactActivity.class)));
    }
}
