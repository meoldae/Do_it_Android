package com.example.mission03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    Button button_up;
    Button button_down;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        button_up =  findViewById(R.id.button_up);
        button_down =  findViewById(R.id.button_down);

        }

        public void onButtonClicked(View v){
            imageChange();
    }

    public void imageChange() {
        if (count == 0) {
            imageView1.setImageResource(R.drawable.wak_messi);
            imageView2.setImageResource(R.drawable.wak_gell_messi);

            imageView1.invalidate();
            imageView2.invalidate();

            count++;
        }
        else{
            imageView1.setImageResource(R.drawable.wak_gell_messi);
            imageView2.setImageResource(R.drawable.wak_messi);

            imageView1.invalidate();
            imageView2.invalidate();

            count--;
        }
    }
}