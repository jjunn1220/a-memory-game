package com.example.a15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class gameover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        TextView output = (TextView) findViewById(R.id.output);
        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        output.setText(score);

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = new DataOutputStream(bos);

        try{
            fos = openFileOutput("rank.txt", MODE_APPEND);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            dos.writeUTF(score);
            dos.flush();
        } catch (Exception e){
            System.out.println("안돼 1");
            return;
        } finally {
            try{
                if(dos != null) dos.close();
                if(dos!= null) bos.close();
                if(dos != null) fos.close();
            } catch (Exception E) {
            }
        }
    }
    public void regame(View view){
        Intent intent = new Intent(getApplicationContext(),game.class);
        startActivity(intent);
    }
    public void main(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}