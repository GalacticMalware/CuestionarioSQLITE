package com.example.danie.cuestionario;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Configuraciones extends AppCompatActivity {
 ConstraintLayout mLayout;
 int Cambiar_color;
    String Resultado;
   String ModoB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones);
        Button Activar = findViewById(R.id.Activar);
        final TextView esto1 = findViewById(R.id.esto);
        Cambiar_color = ContextCompat.getColor(Configuraciones.this,R.color.colorPrimary);
        final Button botonColor =(Button) findViewById(R.id.cambiar);
        final String [] ModoA = getResources().getStringArray(R.array.modo);
        Button guardar1= findViewById(R.id.Guardar_Conf);
        guardar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i); }});
        SharedPreferences shared = getSharedPreferences("Color",Context.MODE_PRIVATE);
        String name =  shared.getString("c","");
        String a=name;
        Toast.makeText(getApplicationContext(),""+name,Toast.LENGTH_SHORT).show();
        if(name.equals("")){
            Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
        }
        else {getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+name)));}
        Activar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =new AlertDialog.Builder(Configuraciones.this);
                builder.setTitle("Seleccione el modo").setSingleChoiceItems(R.array.modo, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0: ModoB = (String) ModoA[which];break;
                            case 1: ModoB = (String) ModoA[which];break;
                        } }}).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(ModoB == ModoA[0]){
                            SharedPreferences preferences=getSharedPreferences("MOD",Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("modo",ModoB);
                            editor.apply();
                            Toast.makeText(getApplicationContext(),"Se a "+ModoB,Toast.LENGTH_SHORT).show();
                            SharedPreferences shared = getSharedPreferences("MOD",Context.MODE_PRIVATE);
                            String name = shared.getString("modo","");
                            esto1.setText(name);
                        }

                        if(ModoB == ModoA[1]){
                            SharedPreferences preferences=getSharedPreferences("MOD",Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("modo",ModoB);
                            editor.apply();
                            Toast.makeText(getApplicationContext(),"Se a "+ModoB,Toast.LENGTH_SHORT).show();
                            SharedPreferences shared = getSharedPreferences("MOD",Context.MODE_PRIVATE);
                            String name = shared.getString("modo","");
                            esto1.setText(name); } }});builder.show(); }});

        Button guardar =findViewById(R.id.cambiar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Configuraciones.this, Bienvenida.class);
                Bundle a = new Bundle();
                a.putString("Color", Resultado);
                intent.putExtras(a);
                startActivity(intent); }});
        botonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openColorPicker(); }}); }
    public void openColorPicker(){
        AmbilWarnaDialog openColorPicker = new AmbilWarnaDialog(this, Cambiar_color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) { }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                Cambiar_color = color;
                Resultado =Integer.toHexString(Cambiar_color);
                SharedPreferences preferences=getSharedPreferences("Color",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("c",Resultado);
                editor.apply();
               // Toast.makeText(getApplicationContext(),"Se a "+Resultado,Toast.LENGTH_SHORT).show();
                SharedPreferences shared = getSharedPreferences("Color",Context.MODE_PRIVATE);
                String name = shared.getString("c","");
               //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+Resultado)));

            }});openColorPicker.show();
    }}