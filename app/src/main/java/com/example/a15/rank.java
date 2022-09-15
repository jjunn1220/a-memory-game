package com.example.a15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class rank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        TextView rank = (TextView) findViewById(R.id.rank);
        String str = "";
        String fin = "";
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = openFileInput("rank.txt");
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            while (dis.available() > 0) {
                String data = dis.readUTF();
                str +=  data + " " ;
            }
            rank.setText(str);
        } catch (FileNotFoundException fnfe) {
            return;
        } catch (Exception e) {

        }
         finally {
            if (dis != null) {
                try {
                    if (bis != null) dis.close();
                    if (bis != null) bis.close();
                    if (fis != null) fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String [] str_fin = str.split(" ");
        int [] rank_int = new int[str_fin.length];
        Arrays.fill(rank_int, 0);
        for(int i = 0; i < str_fin.length; i++){
            rank_int[i] = Integer.parseInt(str_fin[i]);
        }
        Integer[] rank_fin = Arrays.stream(rank_int).boxed().toArray(Integer[]::new);
        Arrays.sort(rank_fin, Collections.reverseOrder());

        for(int i = 0; i < 9; i++){
            fin += String.valueOf(i+1) + ".\t\t\t";
            if(i >= rank_fin.length){
                fin += "랭크 없음";
            }
            else{
                fin += String.valueOf(rank_fin[i]);
            }
            fin += "\n";
        }
        fin+=String.valueOf(10) + ".\t\t";
        if(9 >= rank_fin.length){
            fin += "랭크 없음";
        }
        else{
            fin += String.valueOf(rank_fin[9]);
        }
        rank.setText(fin);
    }
    public void main(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}