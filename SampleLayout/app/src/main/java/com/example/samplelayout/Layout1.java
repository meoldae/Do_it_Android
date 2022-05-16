package com.example.samplelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout1 extends LinearLayout {
    ImageView imageView;
    TextView name;
    TextView ph;

    public Layout1(Context context) {
        super(context);
        init(context);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1, this, true);

        imageView = findViewById(R.id.thumbnail);
        name = findViewById(R.id.name);
        ph = findViewById(R.id.ph);
    }

    public void setImage(int resId){
        imageView.setImageResource(resId);
    }

    public void setName(String name){
        this.name.setText(name);
    }

    public void setPh(String numberSequence){
        ph.setText(numberSequence);
    }
}
