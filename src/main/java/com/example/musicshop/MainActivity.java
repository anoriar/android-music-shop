package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        this.quantity++;
        quantityTextView.setText(String.valueOf(this.quantity));
    }
}