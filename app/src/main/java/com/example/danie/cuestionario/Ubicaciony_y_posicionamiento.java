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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Ubicaciony_y_posicionamiento extends AppCompatActivity {

    private ListView Preguntas;
    String numero="";
    Random Ale;
    int num=0,posicion,puntos=0,aleatori;
    String seleccion1,seleccion2,seleccion3,seleccion4,seleccion5,seleccion6,seleccion7,seleccion8,seleccion9,seleccion10;
    boolean P1=true,P2=true,P3=true,P4=true,P5=true,P6=true,P7=true,P8=true,P9=true,P10=true;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciony_y_posicionamiento);
        SharedPreferences shared = getSharedPreferences("Color",Context.MODE_PRIVATE);
        String name =  shared.getString("c","");
        if(name.equals("")){ Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show(); }
        else {getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+name)));}
        Preguntas = findViewById(R.id.Pregunta3);
        final String [] Pregunta1_Ubicacion =getResources().getStringArray(R.array.Pregunta1_Ubicacion);
        final String [] Pregunta2_Ubicacion =getResources().getStringArray(R.array.Pregunta2_Ubicacion);
        final String [] Pregunta3_Ubicacion =getResources().getStringArray(R.array.Pregunta3_Ubicacion);
        final String [] Pregunta4_Ubicacion =getResources().getStringArray(R.array.Pregunta4_Ubicacion);
        final String [] Pregunta5_Ubicacion =getResources().getStringArray(R.array.Pregunta5_Ubicacion);
        final String [] Pregunta6_Ubicacion =getResources().getStringArray(R.array.Pregunta6_Ubicacion);
        final String [] Pregunta7_Ubicacion =getResources().getStringArray(R.array.Pregunta7_Ubicacion);
        final String [] Pregunta8_Ubicacion =getResources().getStringArray(R.array.Pregunta8_Ubicacion);
        final String [] Pregunta9_Ubicacion =getResources().getStringArray(R.array.Pregunta9_Ubicacion);
        final String [] Pregunta10_Ubicacion=getResources().getStringArray(R.array.Pregunta10_Ubicacion);
        final Bundle bundle = this.getIntent().getExtras();
        numero=(bundle.getString("Numero"));
        num=Integer.parseInt(numero);
        aleatori=(int)(Math.random()*num+1);
        final ArrayList<String> listaPreguntas=new ArrayList<>();
        for(int i=1;i<=num;i++){}
        if(num>=1){ listaPreguntas.add("1.-Seleccione el permiso que se genera en la imagen"); }
        if(num>1){ listaPreguntas.add("2.-Seleccione el comando para entrar a la terminal de PowerShell"); }
        if(num>2){ listaPreguntas.add("3.-Seleccione el comando para dar informacion del usuario"); }
        if(num>3){ listaPreguntas.add("4.-Seleccione la extencion que indique un archivo ejecutable CMD y PowerShell"); }
        if(num>4){ listaPreguntas.add("5.-Seleccione el comando para abrir las particiones del disco"); }
        if(num>5){ listaPreguntas.add("6.-Seleccione la sintaxis correcta para enlistar las particiones");}
        if(num>6){ listaPreguntas.add("7.-Seleccione el comando para conexion FTP"); }
        if(num>7){ listaPreguntas.add("8.-Seleccione la sintaxis correcta para iniciar una conexion FTP");}
        if(num>8){ listaPreguntas.add("9.-Seleccione el comando para enlistar los servicios inicados de un computador");}
        if(num>9){ listaPreguntas.add("10.-Seleccione la sintaxis correcta para ir a una carpeta");}
        if(num>=1){listaPreguntas.add("                              CALIFICAR");}
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaPreguntas);
        Preguntas.setAdapter(adapter);
        Preguntas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                posicion = position + 1;
                if(posicion<=10){ Toast.makeText(getApplicationContext(), "A selecionado la pregunta " + posicion, Toast.LENGTH_SHORT).show(); }
            /* Toast.makeText(parent.getContext(),"Selecionado: "
            +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
*/
                //-------------------------------------------------------------------Pregunta1

                {if ( P1==true && Preguntas.getItemAtPosition(position).equals("1.-Seleccione el permiso que se genera en la imagen" )) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setIcon(R.drawable.ubi);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta1_Ubicacion, -1, new DialogInterface.OnClickListener()  {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion1 = (String) Pregunta1_Ubicacion[0]; break;
                                case 1: seleccion1 = (String) Pregunta1_Ubicacion[which]; break;
                                case 2: seleccion1 = (String) Pregunta1_Ubicacion[which]; break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),""+aleatori,Toast.LENGTH_SHORT).show();
                            if (seleccion1 == Pregunta1_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1; P1=false;}
                            if (seleccion1 == Pregunta1_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P1=false;}
                            if (seleccion1 == Pregunta1_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P1=false;
                            }}});builder.show();}} if(P1==false && Preguntas.getItemAtPosition(position).equals("1.-Seleccione el permiso que se genera en la imagen"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion1);builder.show();}

                ///---------------------------------------------------------------------------Pregunta2-----------------------------
                if (P2==true && Preguntas.getItemAtPosition(position).equals("2.-Seleccione el comando para entrar a la terminal de PowerShell")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta2_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion2 = (String) Pregunta2_Ubicacion[0]; break;
                                case 1: seleccion2 = (String) Pregunta2_Ubicacion[which]; break;
                                case 2: seleccion2 = (String) Pregunta2_Ubicacion[which];break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion2 == Pregunta2_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P2=false; }
                            if (seleccion2 == Pregunta2_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P2=false;}
                            if (seleccion2 == Pregunta2_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P2=false;
                            }}});builder.show();} if(P2==false && Preguntas.getItemAtPosition(position).equals("2.-Seleccione el comando para entrar a la terminal de PowerShell"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion2);builder.show();}

////////////////////////////////////////////----------------------------------------------------Pregunta3////////////////////////
                if (P3==true && Preguntas.getItemAtPosition(position).equals("3.-Seleccione el comando para dar informacion del usuario")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta3_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion3 = (String) Pregunta3_Ubicacion[0];break;
                                case 1: seleccion3 = (String) Pregunta3_Ubicacion[which];break;
                                case 2: seleccion3 = (String) Pregunta3_Ubicacion[which];break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion3 == Pregunta3_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P3=false; }
                            if (seleccion3 == Pregunta3_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P3=false;}
                            if (seleccion3 == Pregunta3_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P3=false;
                            }}});builder.show();} if(P3==false && Preguntas.getItemAtPosition(position).equals("3.-Seleccione el comando para dar informacion del usuario"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion3);builder.show();}

                ////////////////////////////////////////////----------------------------------------------------Pregunta4////////////////////////
                if (P4==true && Preguntas.getItemAtPosition(position).equals("4.-Seleccione la extencion que indique un archivo ejecutable CMD y PowerShell")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta4_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion4 = (String) Pregunta4_Ubicacion[0];break;
                                case 1: seleccion4 = (String) Pregunta4_Ubicacion[which];break;
                                case 2: seleccion4 = (String) Pregunta4_Ubicacion[which];break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion4 == Pregunta4_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P4=false; }
                            if (seleccion4 == Pregunta4_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P4=false; }
                            if (seleccion4 == Pregunta4_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P4=false;
                            }}});builder.show();} if(P4==false && Preguntas.getItemAtPosition(position).equals("4.-Seleccione la extencion que indique un archivo ejecutable CMD y PowerShell"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion4);builder.show();}

////////////////////////////////////////////----------------------------------------------------Pregunta5////////////////////////
                if (P5==true && Preguntas.getItemAtPosition(position).equals("5.-Seleccione el comando para abrir las particiones del disco")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta5_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion5 = (String) Pregunta5_Ubicacion[0];break;
                                case 1: seleccion5 = (String) Pregunta5_Ubicacion[which];break;
                                case 2: seleccion5 = (String) Pregunta5_Ubicacion[which];break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion5 == Pregunta5_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P5=false;}
                            if (seleccion5 == Pregunta5_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P5=false; }
                            if (seleccion5 == Pregunta5_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P5=false;
                            }}});builder.show();}if(P5==false && Preguntas.getItemAtPosition(position).equals("5.-Seleccione el comando para abrir las particiones del disco"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion5);builder.show();}

                ////////////////////////////////////////////----------------------------------------------------Pregunta6////////////////////////
                if (P6==true && Preguntas.getItemAtPosition(position).equals("6.-Seleccione la sintaxis correcta para enlistar las particiones")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta6_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion6 = (String) Pregunta6_Ubicacion[0]; break;
                                case 1: seleccion6 = (String) Pregunta6_Ubicacion[which]; break;
                                case 2: seleccion6 = (String) Pregunta6_Ubicacion[which]; break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion6 == Pregunta6_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P6=false;}
                            if (seleccion6 == Pregunta6_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P6=false;}
                            if (seleccion6 == Pregunta6_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P6=false;
                            }}});builder.show();} if(P6==false && Preguntas.getItemAtPosition(position).equals("6.-Seleccione la sintaxis correcta para enlistar las particiones"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion6);builder.show();}

                ////////////////////////////////////////////----------------------------------------------------Pregunta7////////////////////////
                if (P7==true && Preguntas.getItemAtPosition(position).equals("7.-Seleccione el comando para conexion FTP")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta7_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion7 = (String) Pregunta7_Ubicacion[0]; break;
                                case 1: seleccion7 = (String) Pregunta7_Ubicacion[which]; break;
                                case 2: seleccion7 = (String) Pregunta7_Ubicacion[which]; break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion7 == Pregunta7_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P7=false; }
                            if (seleccion7 == Pregunta7_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Inorrecto", Toast.LENGTH_SHORT).show(); P7=false;}
                            if (seleccion7 == Pregunta7_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P7=false;
                            }}});builder.show();}if(P7==false && Preguntas.getItemAtPosition(position).equals("7.-Seleccione el comando para conexion FTP"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion7);builder.show();}

                ////////////////////////////////////////////----------------------------------------------------Pregunta8////////////////////////
                if (P8==true && Preguntas.getItemAtPosition(position).equals("8.-Seleccione la sintaxis correcta para iniciar una conexion FTP")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta8_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion8 = (String) Pregunta8_Ubicacion[0]; break;
                                case 1: seleccion8 = (String) Pregunta8_Ubicacion[which]; break;
                                case 2: seleccion8 = (String) Pregunta8_Ubicacion[which]; break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion8 == Pregunta8_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P8=false;}
                            if (seleccion8 == Pregunta8_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P8=false;}
                            if (seleccion8 == Pregunta8_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P8=false;
                            }}});builder.show();}if(P8==false && Preguntas.getItemAtPosition(position).equals("8.-Seleccione la sintaxis correcta para iniciar una conexion FTP"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion8);builder.show();}

                ////////////////////////////////////////////----------------------------------------------------Pregunta9////////////////////////
                if (P9==true && Preguntas.getItemAtPosition(position).equals("9.-Seleccione el comando para enlistar los servicios inicados de un computador")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta9_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion9 = (String) Pregunta9_Ubicacion[0]; break;
                                case 1: seleccion9 = (String) Pregunta9_Ubicacion[which]; break;
                                case 2: seleccion9 = (String) Pregunta9_Ubicacion[which]; break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion9 == Pregunta9_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P9=false;}
                            if (seleccion9 == Pregunta9_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Inorrecto", Toast.LENGTH_SHORT).show(); P9=false;}
                            if (seleccion9 == Pregunta9_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P9=false;
                            }}});builder.show();}if(P9==false && Preguntas.getItemAtPosition(position).equals("9.-Seleccione el comando para enlistar los servicios inicados de un computador"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion9);builder.show();}

                ////////////////////////////////////////////----------------------------------------------------Pregunta10////////////////////////
                if (P10==true && Preguntas.getItemAtPosition(position).equals("10.-Seleccione la sintaxis correcta para ir a una carpeta")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("Seleccione la respuesta correcta").setSingleChoiceItems(R.array.Pregunta10_Ubicacion, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: seleccion10 = (String) Pregunta10_Ubicacion[0]; break;
                                case 1: seleccion10 = (String) Pregunta10_Ubicacion[which]; break;
                                case 2: seleccion10 = (String) Pregunta10_Ubicacion[which]; break;
                            }}}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (seleccion10 == Pregunta10_Ubicacion[0]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show(); P10=false;}
                            if (seleccion10 == Pregunta10_Ubicacion[1]) { Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show(); puntos+=1;P10=false;}
                            if (seleccion10 == Pregunta10_Ubicacion[2]) { Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();P10=false;
                            }}});builder.show();}if(P10==false && Preguntas.getItemAtPosition(position).equals("10.-Seleccione la sintaxis correcta para ir a una carpeta"))
                {AlertDialog.Builder builder=new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);builder.setTitle("Usted ya ha contestado la pregunta:"+posicion).setMessage("Respuesta: "+seleccion10);builder.show();}

                ////////////////-------------------------AFIRMACION------------------------
                if(Preguntas.getItemAtPosition(position).equals("                              CALIFICAR")){
                    // Toast.makeText(getApplicationContext(),"Esto"+P1,Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Ubicaciony_y_posicionamiento.this);
                    builder.setTitle("¿Esta seguro de continuar?").setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Ubicaciony_y_posicionamiento.this,Guardar.class);
                            Bundle a = new Bundle();
                            String munPuntos ;
                            munPuntos=Integer.toString(puntos);
                            a.putString("Numero",munPuntos);
                            a.putString("Preguntas",numero);
                            intent.putExtras(a);
                            startActivity(intent); }});builder.show(); }
            }});}
}
