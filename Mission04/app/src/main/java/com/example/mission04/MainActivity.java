package com.example.mission04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    EditText inputValue;
    TextView textcount;
    Button send;
    Button end;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.editText);
        textcount = findViewById(R.id.textView);
        send = findViewById(R.id.buttonSend);
        end  = findViewById(R.id.buttonEnd);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
                byte[] bytes = null;
                try{
                    bytes = charSequence.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    textcount.setText(strCount + " / 80바이트");
                } catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable strEditable) {
                String str = strEditable.toString();
                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if(strBytes.length > 80) {
                        strEditable.delete(strEditable.length()-2, strEditable.length()-1);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        inputValue.addTextChangedListener(watcher);

    }

    public void onClickSend(View v){
        String message = inputValue.getText().toString();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void onClickEnd(View v){
        finish();
    }
}