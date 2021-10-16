package com.example.budgettrackermysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asyncタスククラスのインスタンスを作成し、実行する
        TaskDbConnect task = new TaskDbConnect(MainActivity.this);
        task.execute();

        FloatingActionButton fab = findViewById(R.id.add_bufget_info_fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewBudgetEntry.class);
            startActivityForResult(intent, 1);
        });
    }
}