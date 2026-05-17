package com.example.learningprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer life = 3;

        button = findViewById(R.id.home_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, GameActivity1.class);
            intent.putExtra("life", life);
            startActivity(intent);
        });
    }

}