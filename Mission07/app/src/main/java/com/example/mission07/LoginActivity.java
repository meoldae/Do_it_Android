package com.example.mission07;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 101;
    public static final String KEY_BUTTON_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button customerButton = findViewById(R.id.customerButton);
        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                ButtonName buttonName = new ButtonName(customerButton.getText().toString());
                intent.putExtra(KEY_BUTTON_NAME, buttonName);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        Button salesButton = findViewById(R.id.salesButton);
        salesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                ButtonName buttonName = new ButtonName(salesButton.getText().toString());
                intent.putExtra(KEY_BUTTON_NAME, buttonName);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        Button productsButton = findViewById(R.id.productsButton);
        productsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                ButtonName buttonName = new ButtonName(productsButton.getText().toString());
                intent.putExtra(KEY_BUTTON_NAME, buttonName);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}