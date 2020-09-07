package com.example.danie.cuestionario;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView uno = findViewById(R.id.primer);
        TextView dos = findViewById(R.id.segundo);
        TextView tre = findViewById(R.id.tercero);
        TextView cuatro = findViewById(R.id.cuarto);
        TextView cinco = findViewById(R.id.quinto);


/*
        SharedPreferences shared1 = getSharedPreferences("Puntos1",Context.MODE_PRIVATE);
        String name1 =  shared1.getString("score1","");
        uno.setText(name1);

        SharedPreferences shared2 = getSharedPreferences("Puntos2",Context.MODE_PRIVATE);
        String name2 =  shared2.getString("score2","");
        dos.setText(name2);

        SharedPreferences shared3 = getSharedPreferences("Puntos3",Context.MODE_PRIVATE);
        String name3 =  shared3.getString("score3","");
        tre.setText(name3);

        SharedPreferences shared4 = getSharedPreferences("Puntos4",Context.MODE_PRIVATE);
        String name4 =  shared4.getString("score4","");
        cuatro.setText(name4);
*/
        final Bundle bundle = this.getIntent().getExtras();
        String uno1=(bundle.getString("Uno"));
        String dos1=(bundle.getString("Dos"));
        String tres1=(bundle.getString("Tres"));
        String cuatro1=(bundle.getString("Cuatro"));
        String cinco1=(bundle.getString("Cinco"));
        uno.setText(uno1);
        dos.setText(dos1);
        tre.setText(tres1);
        cuatro.setText(cuatro1);
        cinco.setText(cinco1);



    }
}
