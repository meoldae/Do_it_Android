package com.example.samplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("전준영","010-3311-1936"));
        adapter.addItem(new Person("홍길동","010-0000-0000"));
        adapter.addItem(new Person("김태리","010-1234-1234"));

        recyclerView.setAdapter(adapter);
    }
}