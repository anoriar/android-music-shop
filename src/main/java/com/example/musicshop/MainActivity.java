package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    double price;
    String goodsName;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.editTextTextPersonName);

        this.createSpinner();
        this.createMap();
    }

    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap() {
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 1000.0);
    }

    public void increaseQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        this.quantity++;
        quantityTextView.setText(String.valueOf(this.quantity));

        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + price * quantity);
    }

    public void decreaseQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        this.quantity--;
        if (this.quantity < 0) {
            this.quantity = 0;
        }
        quantityTextView.setText(String.valueOf(this.quantity));

        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + price * quantity);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);

        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + price * quantity);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        switch (goodsName) {
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard":
                goodsImageView.setImageResource(R.drawable.keyboard);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCart(View view) {
        Order order = new Order();
        order.userName = userNameEditText.getText().toString();
        order.goodsName = goodsName;
        order.quantity = quantity;
        order.price = price;
    }
}