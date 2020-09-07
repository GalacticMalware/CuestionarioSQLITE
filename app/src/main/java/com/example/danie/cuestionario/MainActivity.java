package com.example.danie.cuestionario;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private  EditText Usu, Contra;
private Button menu;
String usuario= "767";
String contar  = "767" +
        "";
String nombreUsuario="Gloria 762";
    Handler delay;
    Runnable delayStart;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    SharedPreferences shared = getSharedPreferences("Color",Context.MODE_PRIVATE);
    String name =  shared.getString("c","");
    if(name.equals("")){ Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show(); }
    else {getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+name)));}
        menu = (Button)findViewById(R.id.menu);
        Usu= (EditText)findViewById(R.id.usuario);
    Contra = (EditText)findViewById(R.id.contrasena);
        Usu.getText().toString();
        Contra.getText().toString();


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Usu.getText().toString().equals("")){ Toast toast = Toast.makeText(getApplicationContext(),"Ingrese el usuario",Toast.LENGTH_LONG);toast.show(); }
                else if (Contra.getText().toString().equals("")){
                    delayStart=new Runnable() {
                        @Override
                        public void run() {
                            Toast toast =Toast.makeText(getApplicationContext(),"Ingrese la contrasena",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    };
                    delay.postDelayed(delayStart,100);
                }
                else if(Contra.getText().toString().equals(contar)&& Usu.getText().toString().equals(usuario)){
                    Intent intent = new Intent(MainActivity.this,Bienvenida.class);
                    startActivity(intent);
                }
                else {
                    Toast toast =Toast.makeText(getApplicationContext(),"Ingrese los campos",Toast.LENGTH_LONG);
                    toast.show();
                   // Intent intent = new Intent(MainActivity.this,Bienvenida.class);
                   // startActivity(intent);
                    } }});
}

}
