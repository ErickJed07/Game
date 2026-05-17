package com.example.learningprocess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Random;

public class GameOverDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("GAME OVER")
                .setMessage("You selected the wrong shape!")
                .setPositiveButton("New Game?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Random randomGenerator = new Random();
                        int number = randomGenerator.nextInt(4) + 1;

                        Class activity = null;

                        switch(number) {
                            case 1:
                                activity = GameActivity1.class;
                                break;
                            case 2:
                                activity = GameActivity2.class;
                                break;
                            case 3:
                                activity = GameActivity3.class;
                                break;
                            default:
                                activity = GameActivity4.class;
                                break;
                        }
                        openGridShape(activity);
                    }
                })
                .setNegativeButton("Back to Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }

    private void openGridShape(Class activity) {
        Integer life = 3;
        Intent intent = new Intent(getActivity(), activity);
        intent.putExtra("life", life);
        startActivity(intent);
    }
}
