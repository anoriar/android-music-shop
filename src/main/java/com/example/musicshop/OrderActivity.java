package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Your order");

        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userName");
        String goodsName = orderIntent.getStringExtra("goodsName");
        int quantity = orderIntent.getIntExtra("quantity", 0);
        double price = orderIntent.getDoubleExtra("price", 0.0);
        double orderPrice = orderIntent.getDoubleExtra("orderPrice", 0.0);

        TextView userNameTextView = findViewById(R.id.userNameTextView);
        TextView goodsNameTextView = findViewById(R.id.goodsNameTextView);
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        TextView orderPriceTextView = findViewById(R.id.orderPriceTextView);

        userNameTextView.setText(userName);
        goodsNameTextView.setText(goodsName);
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText(String.valueOf(price));
        orderPriceTextView.setText(String.valueOf(orderPrice));
    }
}