package com.example.mission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CUSTOMER = 102;
    public static final int REQUEST_SALES = 103;
    public static final int REQUEST_PRODUCT = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // From Login Activity
        Intent intent = getIntent();
        Toast.makeText(this, "From Login Activity", Toast.LENGTH_LONG).show();

        Button customerButton = findViewById(R.id.customerButton);
        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Customer.class);
                startActivityForResult(intent, REQUEST_CUSTOMER);
            }
        });

        Button salesButton = findViewById(R.id.salesButton);
        salesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sales.class);
                startActivityForResult(intent, REQUEST_SALES);
            }
        });

        Button productsButton = findViewById(R.id.productsButton);
        productsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Products.class);
                startActivityForResult(intent, REQUEST_PRODUCT);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        if (intent != null){
            switch (requestCode) {
                case REQUEST_CUSTOMER:
                    Toast.makeText(getBaseContext(), "고객 관리", Toast.LENGTH_LONG).show();
                    break;

                case REQUEST_SALES:
                    Toast.makeText(getBaseContext(), "매출 관리", Toast.LENGTH_LONG).show();
                    break;

                case REQUEST_PRODUCT:
                    Toast.makeText(getBaseContext(), "상품 관리", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}