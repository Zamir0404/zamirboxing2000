package com.example.boxingrtumirea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView giImageView;
    AppCompatButton button01, button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giImageView = findViewById(R.id.giImageView);
        giImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Random random = new Random();
        int randomImageNumber = 1 + random.nextInt(6);
        switch ( randomImageNumber){
            case 1: giImageView.setImageResource(R.drawable.gi_01);break;
            case 2: giImageView.setImageResource(R.drawable.gi_02);break;
            case 3: giImageView.setImageResource(R.drawable.gi_03);break;
            case 4: giImageView.setImageResource(R.drawable.gi_04);break;
            case 5: giImageView.setImageResource(R.drawable.gi_05);break;
            case 6: giImageView.setImageResource(R.drawable.gi_06);break;
        }
        button01 = findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Exercise.class);
                intent.putExtra("День", 1);
                startActivity(intent);
                finish();
            }
        });
        button02 = findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Exercise.class);
                intent.putExtra("День", 2);
                startActivity(intent);
                finish();
            }
        });

        }
        }