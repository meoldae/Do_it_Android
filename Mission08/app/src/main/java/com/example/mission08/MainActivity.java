package com.example.mission08;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 101;

    EditText ID;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ID = findViewById(R.id.ID);
        password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idInput = ID.getText().toString();
                String passwdInput = password.getText().toString();
                if (!idInput.isEmpty() && !passwdInput.isEmpty()) {

                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("ID", idInput);
                    intent.putExtra("PW", passwdInput);

                    startActivityForResult(intent, REQUEST_CODE);

                }else{
                    Toast.makeText(getApplicationContext(), "ID/PW를 모두 입력하세요.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}