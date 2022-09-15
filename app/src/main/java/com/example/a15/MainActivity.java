package com.example.a15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        Intent intent = new Intent(getApplicationContext(),game.class);
        startActivity(intent);
    }

    public void rank(View view){
        Intent intent = new Intent(getApplicationContext(),rank.class);
        startActivity(intent);
    }
    public void end(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}