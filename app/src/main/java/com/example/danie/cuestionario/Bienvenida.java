package com.example.danie.cuestionario;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Bienvenida extends AppCompatActivity {

private Button Ingresa;
private EditText numero;
private RadioButton segu,list,shell;
int limite=0;
String limite1="";
    String Resultado;
boolean colores=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        //Color Predeterminado
        SharedPreferences shared = getSharedPreferences("Color",Context.MODE_PRIVATE);
        String name =  shared.getString("c","");
        if(name.equals("")){ Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show(); }
        else {getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+name)));}

        //Botones
        Button PoweShell = findViewById(R.id.PowerShell);
        Button Seguridad = findViewById(R.id.Segurida);
        Button List = findViewById(R.id.List);
        ////////////////////////PowerShell
        PoweShell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Bienvenida.this);
                View power = getLayoutInflater().inflate(R.layout.numero_de_preguntas,null);
                final EditText numero_preguntas = power.findViewById(R.id.numero_preguntas);
                Button ingresar_power = power.findViewById(R.id.Ingresar_Power);
                ingresar_power.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int numero=0;
                        String s = numero_preguntas.toString();
                        numero = Integer.parseInt(numero_preguntas.getText().toString());
                        if(numero>10){ Toast.makeText(getApplicationContext(),"El maximo numero de preguntas es 10",Toast.LENGTH_SHORT).show(); }
                        else { Intent intent = new Intent(Bienvenida.this, PowerShell.class);
                            Bundle a = new Bundle();
                           a.putString("Numero", numero_preguntas.getText().toString());
                            intent.putExtras(a);
                            startActivity(intent); } }});
                builder.setView(power);
                AlertDialog dialog =builder.create();
                dialog.show(); }});

        ///////////////////ListView
        List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Bienvenida.this);
                View power = getLayoutInflater().inflate(R.layout.numero_de_preguntas_list,null);
                final EditText numero_preguntas = power.findViewById(R.id.numero_preguntas);
                Button ingresar_power = power.findViewById(R.id.Ingresar_Power);
                ingresar_power.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int numero=0;
                        String s = numero_preguntas.toString();
                        numero = Integer.parseInt(numero_preguntas.getText().toString());
                        if(numero>10){ Toast.makeText(getApplicationContext(),"El maximo numero de preguntas es 10",Toast.LENGTH_SHORT).show(); }
                        else { Intent intent = new Intent(Bienvenida.this, List_View.class);
                            Bundle a = new Bundle();
                            a.putString("Numero", numero_preguntas.getText().toString());
                            intent.putExtras(a);
                            startActivity(intent); } }});
                builder.setView(power);
                AlertDialog dialog =builder.create();
                dialog.show(); }});

        //////////////Seguridad
        Seguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Bienvenida.this);
                View power = getLayoutInflater().inflate(R.layout.numero_de_preguntas_seguridad,null);
                final EditText numero_preguntas = power.findViewById(R.id.numero_preguntas);
                Button ingresar_power = power.findViewById(R.id.Ingresar_Power);
                ingresar_power.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int numero=0;
                        String s = numero_preguntas.toString();
                        numero = Integer.parseInt(numero_preguntas.getText().toString());
                        if(numero_preguntas.equals("-")){ Toast.makeText(getApplicationContext(),"No puede ingresar ese caracter",Toast.LENGTH_SHORT).show(); }
                       else if(numero==0){Toast.makeText(getApplicationContext(),"Ingrese un numero mayor a 0",Toast.LENGTH_SHORT).show();}
                       else if(numero>10){ Toast.makeText(getApplicationContext(),"El maximo numero de preguntas es 10",Toast.LENGTH_SHORT).show(); }
                       else if(numero_preguntas.equals("")){Toast.makeText(getApplicationContext(),"Ingrese un numero mayor a 0",Toast.LENGTH_SHORT).show();}
                        else { Intent intent = new Intent(Bienvenida.this, Ubicaciony_y_posicionamiento.class);
                            Bundle a = new Bundle();
                            a.putString("Numero", numero_preguntas.getText().toString());
                            intent.putExtras(a);
                            startActivity(intent); } }});
                builder.setView(power);
                AlertDialog dialog =builder.create();
                dialog.show();
            }});
    }


    ////////////////////////Menu Botones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Bienvenida.this);
            View acerca = getLayoutInflater().inflate(R.layout.acerca_de,null);
            builder.setView(acerca);
            AlertDialog dialog =builder.create();
            dialog.show();
        }

        if (id == R.id.conf) {
            colores=false;
            Intent intent = new Intent(Bienvenida.this,Configuraciones.class);
            startActivity(intent);
        }
        if (id == R.id.salir) {
            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage( getBaseContext().getPackageName() );
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        }




        if (id == R.id.score) {
            Intent intent = new Intent(Bienvenida.this, Score.class);
            Bundle a = new Bundle();

            SharedPreferences shared1 = getSharedPreferences("Puntos1",Context.MODE_PRIVATE);
            String name1 =  shared1.getString("score1","");
            int hola=Integer.parseInt(name1);
            Toast.makeText(getApplicationContext(),""+hola,Toast.LENGTH_SHORT).show();
            if(name1.equals("")){
                //Toast.makeText(getApplicationContext(),""+hola,Toast.LENGTH_SHORT).show();
            }
            SharedPreferences shared = getSharedPreferences("Puntos2",Context.MODE_PRIVATE);
            String name2 =  shared.getString("score2","");
            //Toast.makeText(getApplicationContext(),""+name2,Toast.LENGTH_SHORT).show();
            if(name2.equals("")){
               // Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
            }
            SharedPreferences shared3 = getSharedPreferences("Puntos3",Context.MODE_PRIVATE);
            String name3 =  shared3.getString("score3","");
           // Toast.makeText(getApplicationContext(),""+name3,Toast.LENGTH_SHORT).show();
            if(name3.equals("")){
                //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
            }
            SharedPreferences shared4 = getSharedPreferences("Puntos4",Context.MODE_PRIVATE);
            String name4 =  shared4.getString("score4","");
           // Toast.makeText(getApplicationContext(),""+name4,Toast.LENGTH_SHORT).show();
            if(name4.equals("")){
               // Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
            }
            SharedPreferences shared5 = getSharedPreferences("Puntos5",Context.MODE_PRIVATE);
            String name5 =  shared5.getString("score5","");
          //  Toast.makeText(getApplicationContext(),""+name5,Toast.LENGTH_SHORT).show();
            if(name5.equals("")){
                //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
            }






            a.putString("Uno", name1);
            a.putString("Dos", name2);
            a.putString("Tres", name3);
            a.putString("Cuatro", name4);
            a.putString("Cinco", name5);
                intent.putExtras(a);
                startActivity(intent);




        }

        return super.onOptionsItemSelected(item);
    }
}
