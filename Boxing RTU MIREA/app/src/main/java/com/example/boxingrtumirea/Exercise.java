package com.example.boxingrtumirea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Exercise extends AppCompatActivity {
    ImageView giExerciseImageView;
    ImageView baseline;
    TextView  textViewTimer;
    TextView textViewДень0Exercise;
    AppCompatButton giСтарт;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        textViewДень0Exercise = findViewById(R.id.textViewДень0Exercise);
        textViewTimer = findViewById(R.id.textViewTimer);
        baseline = findViewById(R.id.baseline);

        //Начало Старт

        int День = getIntent().getIntExtra("День", 0);
        int seconds = 10 + День * 5;
        int minutes = seconds/60;
        setTimer(seconds,minutes );
        textViewДень0Exercise.setText("День" + День);
        CountDownTimer countDownTimer = new CountDownTimer((10+День*5) * 1000, 1000) {
            @Override
            public void onTick(long l) {
                int minutes = (int)l / 1000/60;
                int seconds = (int) l / 1000 - minutes * 60;
                setTimer(seconds,minutes );

            }

            @Override
            public void onFinish() {

            }
        };

        giСтарт = findViewById(R.id.giСтарт);
        giСтарт.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();
            }
        });
        //Конец

        baseline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        giExerciseImageView = findViewById(R.id.giExerciseImageView);
        giExerciseImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Random random = new Random();
        int randomImageNumber = 1 + random.nextInt(6);
        switch ( randomImageNumber){
            case 1: giExerciseImageView.setImageResource(R.drawable.giex_01);break;
            case 2: giExerciseImageView.setImageResource(R.drawable.giex_02);break;
            case 3: giExerciseImageView.setImageResource(R.drawable.giex_03);break;
            case 4: giExerciseImageView.setImageResource(R.drawable.giex_04);break;
            case 5: giExerciseImageView.setImageResource(R.drawable.giex_05);break;
            case 6: giExerciseImageView.setImageResource(R.drawable.giex_06);break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Exercise.this, MainActivity.class));
        finish();
    }
    private void setTimer(int sec, int min){
        if (sec < 10){
            textViewTimer.setText(min + ":" + 0+sec);
        }else {
            textViewTimer.setText((min) + ":" + String.valueOf(sec));
        }


    }
}