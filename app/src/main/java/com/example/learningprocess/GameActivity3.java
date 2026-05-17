package com.example.learningprocess;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity3 extends AppCompatActivity {

    GridView gridView;
    ArrayList<String> a_text = new ArrayList<>();
    ArrayList<Integer> a_image = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        gridView = findViewById(R.id.gridView);
        fillArray();
        GridAdapter adapter = new GridAdapter(this, a_text, a_image);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = getIntent();
                Integer life = intent.getIntExtra("life", 0);

                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.happy_baby,
                        findViewById(R.id.toast_happy_baby));

                View view2 = inflater.inflate(R.layout.sad_baby,
                        findViewById(R.id.toast_sad_baby));

                int selected = position;
                int squarePosition = a_image.indexOf(R.drawable.square);
                if (selected == squarePosition) {
                    clickCorrectAnswer(life, view1);
                } else {
                    life = life - 1;
                    clickWrongAnswer(life, view2);
                }

                Random randomGenerator = new Random();
                int number = randomGenerator.nextInt(3) + 1;

                Class activity = null;

                switch (number) {
                    case 1:
                        activity = GameActivity1.class;
                        break;
                    case 2:
                        activity = GameActivity2.class;
                        break;
                    default:
                        activity = GameActivity4.class;
                        break;
                }

                if (life <= 0) {
                    openDialog();
                } else {
                    openGridShape(activity, life);
                }
            }
        });


    }

    public void fillArray() {
        a_text.add("Square");
        a_text.add("Pentagon");
        a_text.add("Circle");
        a_text.add("Triangle");

        a_image.add(R.drawable.square);
        a_image.add(R.drawable.pentagon);
        a_image.add(R.drawable.circle);
        a_image.add(R.drawable.triangle);
    }

    private void clickWrongAnswer(Integer life, View view) {
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Toast.makeText(this, String.format("%d lives left", life), Toast.LENGTH_LONG).show();
    }

    private void clickCorrectAnswer(Integer life, View view) {
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Toast.makeText(this, String.format("%d lives left", life), Toast.LENGTH_LONG).show();
    }


    private void openGridShape(Class activity, Integer life) {
        Intent intent = new Intent(this, activity);
        intent.putExtra("life", life);
        startActivity(intent);
    }

    private void openDialog() {
        GameOverDialog gameOverDialog = new GameOverDialog();
        gameOverDialog.show(getSupportFragmentManager(), "game over dialog");
    }
}