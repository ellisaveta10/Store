package com.example.storeF95805;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductModel> {
    public ProductAdapter(Context context, List<ProductModel> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ProductModel product = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = convertView.findViewById(R.id.text_view_product_title);
        TextView tvPrice = convertView.findViewById(R.id.text_view_product_price);

        // Populate the data into the template view using the object data
        tvTitle.setText(product.getTitle());
        tvPrice.setText(String.valueOf(product.getPrice()));

        // Return the completed view to render on screen
        return convertView;
    }
}