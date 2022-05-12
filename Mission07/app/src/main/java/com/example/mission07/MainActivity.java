package com.example.mission07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 101;
    public static final String KEY_BUTTON_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(REQUEST_CODE, resultCode, intent);
        Bundle bundle = intent.getExtras();
        ButtonName buttonName = bundle.getParcelable(KEY_BUTTON_NAME);

        if (requestCode == REQUEST_CODE) {
            Toast.makeText(getBaseContext(), buttonName.name, Toast.LENGTH_LONG).show();
        }
    }
}
