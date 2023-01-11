package com.example.storeF95805;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shop.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PRODUCTS = "products";

    public static final String UID = "_ID";
    public static String COLUMN_PRODUCT_TITLE = "product_title";
    public static String COLUMN_PRODUCT_PRICE = "product_price";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Generate a table
    @Override
    public void onCreate(SQLiteDatabase database) {
        String SQL_CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCT_TITLE + " TEXT NOT NULL," + COLUMN_PRODUCT_PRICE + " REAL);";

        // Execute SQL statement
        database.execSQL(SQL_CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        // Delete old table
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);

        // Create new table
        onCreate(database);

    }

    public boolean addProduct(ProductModel product) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        //ID is auto incremented and doesn't need to be specified

        values.put(MyDatabaseHelper.COLUMN_PRODUCT_TITLE, product.getTitle());
        values.put(MyDatabaseHelper.COLUMN_PRODUCT_PRICE, product.getPrice());

        // insert will be -1 on fail
        long insert = database.insert(TABLE_PRODUCTS, null, values);

        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<ProductModel> getAllProducts() {
        List<ProductModel> productsResult = new ArrayList<>();

        String queryString = "SELECT * FROM " + TABLE_PRODUCTS;

        SQLiteDatabase database = this.getReadableDatabase();

        // Cursor is the result set of a query
        Cursor cursor = database.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // If there are results, loop through the results. Create new product object
            do {
                int productId = cursor.getInt(0);
                String productTitle = cursor.getString(1);
                double productPrice = cursor.getDouble(2);

                ProductModel product = new ProductModel(Integer.toString(productId), productTitle, productPrice);
                productsResult.add(product);

            }
            // Proceed through the db one at a time
            while (cursor.moveToNext());
        }
        else {
            // Failure. Do not add anything to the list
        }

        // Close the cursor and the database when done
        cursor.close();
        database.close();

        return productsResult;
    }
}