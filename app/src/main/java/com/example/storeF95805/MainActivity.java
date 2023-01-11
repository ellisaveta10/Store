package com.example.storeF95805;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutUpper;
    LinearLayout linearLayoutLower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References to layout controls
        linearLayoutUpper = findViewById(R.id.fragment_container_upper);
        linearLayoutLower = findViewById(R.id.fragment_container_lower);

        // Replace the containers with fragments
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_upper, new SaleFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_lower, new ProductsFragment()).commit();
    }
}