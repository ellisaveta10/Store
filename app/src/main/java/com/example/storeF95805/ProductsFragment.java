package com.example.storeF95805;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductsFragment extends Fragment {

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Initialize MyDataBaseHelper
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(getContext());

        // Create and/or open database for writing and reading
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        // Construct the data source
        List<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel("1", "Chocolate", 2.5));
        products.add(new ProductModel("2", "Croissant", 1.99));
        products.add(new ProductModel("3", "Twix", 1.8));

//        products = dbHelper.getAllProducts();

        for (ProductModel product : products) {
            dbHelper.addProduct(product);
        }
        // Create the adapter to convert the array to views
        ProductAdapter adapter = new ProductAdapter(getContext(), products);

        // Attach the adapter to a ListView
        final ListView listView = requireActivity().findViewById(R.id.list_view_products);
        listView.setAdapter(adapter);
    }
}