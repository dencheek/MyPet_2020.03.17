package com.example.mypets;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_main);
        // передаем в recyclerView лэйаут менеджер, иначе он работать не будет
        // layoutManager'у нужен контекст, в нашем случае это this (полиморфизм)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final MyAdapter mAdapter = new MyAdapter(); // делаем константой, чтоб с другого треда обращаться (ниже в onChanged)
        recyclerView.setAdapter(mAdapter);

        // всю требуху описали, теперь можно передать из базы информацию
        AppDatabase.getInstance(this).animalDao().getAll().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {
                mAdapter.setData(animals);
            }
        });
    }
}