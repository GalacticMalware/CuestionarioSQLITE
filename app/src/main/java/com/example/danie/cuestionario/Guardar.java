package com.example.danie.cuestionario;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Guardar extends AppCompatActivity {

    TextView score, nombre, pre;
    String numero1 = "",Preguntas="";
    int num,p;
    float num1,num2,num3,num4,num5;
    float resultado,respuestas,preguntas;
    String nombreUsario = "Daniel 676";
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar);
        score = (TextView) findViewById(R.id.score);
        guardar = (Button) findViewById(R.id.button);
        pre =findViewById(R.id.pre);


        SharedPreferences shared = getSharedPreferences("Color",Context.MODE_PRIVATE);
        String name =  shared.getString("c","");
        if(name.equals("")){ Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show(); }
        else {getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+name)));}

        Bundle bundle = this.getIntent().getExtras();
        numero1 = (bundle.getString("Numero"));
        Preguntas = (bundle.getString("Preguntas"));
        p =Integer.parseInt(Preguntas);
        num = Integer.parseInt(numero1);
        pre.setText(Preguntas);
        score.setText(numero1);
Toast.makeText(getApplicationContext(),""+num,Toast.LENGTH_SHORT).show();








        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preguntas=Float.parseFloat(Preguntas);
                respuestas=Float.parseFloat(numero1);

                resultado = respuestas/preguntas;


               // Toast.makeText(getApplicationContext(),"Se ha guardado el puntuaje",Toast.LENGTH_SHORT).show();






                if(resultado>=1) {
                    SharedPreferences shared1 = getSharedPreferences("Puntos1", Context.MODE_PRIVATE);
                    String name1 = shared1.getString("score1", "");
                    num1 = Float.parseFloat(name1);
                   //  Toast.makeText(getApplicationContext(),""+resultado,Toast.LENGTH_SHORT).show();
                    if (name1.equals("")) {
                        System.out.print("nada :v");
                    }
                    if (num1 >= 1) {
                        Guardar_primero();
                    }
                }




/*

                SharedPreferences shared2 = getSharedPreferences("Puntos2",Context.MODE_PRIVATE);
                String name2 =  shared2.getString("score2","");
                num2 = Float.parseFloat(name2);
                if(name2.equals("")){ Guardar_segundo(); }
                if(resultado>=0.99 && resultado<=0.71) {  Guardar_segundo();  }

                SharedPreferences shared3 = getSharedPreferences("Puntos3",Context.MODE_PRIVATE);
                String name3 =  shared3.getString("score3","");
                num3 = Integer.parseInt(name3);
                if(name3.equals("")){ Guardar_tercero(); }
                if(num3>4&& num3<=5) {  Guardar_tercero();  }

                SharedPreferences shared4 = getSharedPreferences("Puntos4",Context.MODE_PRIVATE);
                String name4 =  shared4.getString("score4","");
                num4 = Integer.parseInt(name4);
                if(name4.equals("")){ Guardar_cuarto(); }
                if(num4>2|| num4==1) {  Guardar_cuarto();  }

                SharedPreferences shared5 = getSharedPreferences("Puntos5",Context.MODE_PRIVATE);
                String name5 =  shared5.getString("score5","");
                num5 = Integer.parseInt(name5);
                Toast.makeText(getApplicationContext(),""+num5,Toast.LENGTH_SHORT).show();
                if(name5.equals("")){ Guardar_quinto(); }
                if(num5==0) {  Guardar_quinto();  }

*/
                Intent intent = new Intent(Guardar.this,Bienvenida.class);
                startActivity(intent);
            }
        });



    }


    public void Guardar_primero(){
        numero1=String.valueOf(respuestas);
        SharedPreferences preferences=getSharedPreferences("Puntos1",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("score1",numero1);
        editor.apply();

        SharedPreferences shared1 = getSharedPreferences("Puntos1",Context.MODE_PRIVATE);
        String name1 = shared1.getString("score1","");
        Toast.makeText(getApplicationContext(),"Tu scor de: "+name1+" se ha guardado 1",Toast.LENGTH_SHORT).show();
    }

    public void Guardar_segundo(){
        SharedPreferences preferences=getSharedPreferences("Puntos2",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("score2",numero1);
        editor.apply();
        Toast.makeText(getApplicationContext(),"Tu scor de: "+numero1+" se ha guardado 2",Toast.LENGTH_SHORT).show();
        SharedPreferences shared1 = getSharedPreferences("Puntos2",Context.MODE_PRIVATE);
        String name1 = shared1.getString("score2","");
    }

    public void Guardar_tercero(){
        SharedPreferences preferences=getSharedPreferences("Puntos3",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("score3",numero1);
        editor.apply();
        Toast.makeText(getApplicationContext(),"Tu scor de: "+numero1+" se ha guardado 3",Toast.LENGTH_SHORT).show();
        SharedPreferences shared1 = getSharedPreferences("Puntos3",Context.MODE_PRIVATE);
        String name1 = shared1.getString("score3","");
    }

    public void Guardar_cuarto(){
        SharedPreferences preferences=getSharedPreferences("Puntos4",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("score4",numero1);
        editor.apply();
        Toast.makeText(getApplicationContext(),"Tu scor de: "+numero1+" se ha guardado 4",Toast.LENGTH_SHORT).show();
        SharedPreferences shared1 = getSharedPreferences("Puntos",Context.MODE_PRIVATE);
        String name1 = shared1.getString("score4","");
    }
    public void Guardar_quinto(){
        SharedPreferences preferences=getSharedPreferences("Puntos5",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("score5",numero1);
        editor.apply();
        Toast.makeText(getApplicationContext(),"Tu scor de: "+numero1+" se ha guardado 5",Toast.LENGTH_SHORT).show();
        SharedPreferences shared1 = getSharedPreferences("Puntos5",Context.MODE_PRIVATE);
        String name1 = shared1.getString("score5","");
    }
}

