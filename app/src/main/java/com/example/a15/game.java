package com.example.a15;

import static kotlin.concurrent.TimersKt.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class game extends AppCompatActivity {
    private ImageView imageview;
    private TextView res;
    private Button red;
    private Button blue;
    private Button green;
    private Button yellow;
    private final Handler handler = new Handler();
    Timer timer = new Timer();
    int [] id;
    int num = 1;
    int j = 0;
    int [] correct = new int[100];
    int [] input;
    int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        random();
    }
    public void random() {
        red = (Button) findViewById(R.id.red);
        blue = (Button) findViewById(R.id.blue);
        green = (Button) findViewById(R.id.green);
        yellow = (Button) findViewById(R.id.yellow);
        res = (TextView)findViewById(R.id.textView);
        TextView round = (TextView)findViewById(R.id.textView3);
        imageview = (ImageView) findViewById(R.id.imageView);

        red.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        yellow.setEnabled(false);

        red.setBackgroundResource(R.drawable.red_g_btn);
        blue.setBackgroundResource(R.drawable.blue_g_btn);
        green.setBackgroundResource(R.drawable.green_g_btn);
        yellow.setBackgroundResource(R.drawable.yellow_g_btn);

        n = 0; // 플레이어 입력 순서 값
        Random rd = new Random();
        input = new int[num];

        round.setText(String.valueOf(num));
        correct[num-1] = rd.nextInt(4);
        //앞의 색상 유지한채로 새로운 랜덤 색상 추가
        id = new int[num+1];
        for (int i = 0; i < num; i++) {
            switch (correct[i]) {
                case (0):
                    id[i] = R.drawable.red;
                    break;
                case (1):
                    id[i] = R.drawable.blue;
                    break;
                case (2):
                    id[i] = R.drawable.yellow;
                    break;
                case (3):
                    id[i] = R.drawable.green;
                    break;
            }
        }
        id[num] = R.drawable.base;
        j = 0;
        TimerTask second = new TimerTask() {
            @Override
            public void run() {
                Update();
                j++;
                if(j == num+1){
                    timer.cancel();
                }
            }
        };
        timer = new Timer();
        timer.schedule(second, 0, 1000);
    }
    protected void Update() {
        Runnable updater = new Runnable() {
            public void run() {
                imageview.setImageResource(id[j-1]);
                if(j != num+1){
                    res.setText(String.valueOf(j));
                }
                else{
                    res.setText("");
                    red.setEnabled(true);
                    blue.setEnabled(true);
                    green.setEnabled(true);
                    yellow.setEnabled(true);

                    red.setBackgroundResource(R.drawable.red_btn);
                    blue.setBackgroundResource(R.drawable.blue_btn);
                    green.setBackgroundResource(R.drawable.green_btn);
                    yellow.setBackgroundResource(R.drawable.yellow_btn);
                }

            }
        };
        handler.post(updater);
    }

    public void red(View view){
        imageview.setImageResource(R.drawable.red);
        res.setText("선택: " + String.valueOf(n+1));
        int in = 0;
        if(correct[n] != in) {
            //페이지 이동
            Intent intent = new Intent(getApplicationContext(),gameover.class);
            intent.putExtra("score", String.valueOf(num));
            startActivity(intent);
        }
        else{
            n++;
            if(n == num){
                num++;
                random();
            }
        }
    }
    public void green(View view){
        imageview.setImageResource(R.drawable.green);
        res.setText("선택: " + String.valueOf(n+1));
        int in = 3;
        if(correct[n] != in) {
            //페이지 이동
            Intent intent = new Intent(getApplicationContext(),gameover.class);
            intent.putExtra("score", String.valueOf(num));
            startActivity(intent);
        }
        else{
            n++;
            if(n == num){
                num++;
                random();
            }
        }
    }
    public void blue(View view){
        imageview.setImageResource(R.drawable.blue);
        res.setText("선택: " + String.valueOf(n+1));
        int in = 1;
        if(correct[n] != in) {
            //페이지 이동
            Intent intent = new Intent(getApplicationContext(),gameover.class);
            intent.putExtra("score", String.valueOf(num));
            startActivity(intent);
        }
        else{
            n++;
            if(n == num){
                num++;
                random();
            }
        }
    }
    public void yellow(View view){
        imageview.setImageResource(R.drawable.yellow);
        res.setText("선택: " + String.valueOf(n+1));
        int in = 2;
        if(correct[n] != in) {
            //페이지 이동
            Intent intent = new Intent(getApplicationContext(),gameover.class);
            intent.putExtra("score", String.valueOf(num));
            startActivity(intent);
        }
        else{
            n++;
            if(n == num){
                num++;
                random();
            }
        }
    }
}