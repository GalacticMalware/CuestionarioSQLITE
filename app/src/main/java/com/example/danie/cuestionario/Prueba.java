package com.example.danie.cuestionario;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class Prueba extends DialogFragment {

    final CharSequence[] Pregunta1_Power = {"A)nest wlan show profiles=\"name\" key=clear","netstart -l -i hostname key=\"number","C)DISKPART -s"};
    final CharSequence[] Pregunta2_Power = {"A)Powershell","B)Net porfile","C)DISKPART"};

    String seleccion;
    int puntos;


    /////////////////////////////////////////////////////////////////////Pregunta1/////////////////
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder preguntas = new AlertDialog.Builder(getActivity());
        preguntas.setTitle("Elija la opcion correcta").setSingleChoiceItems(Pregunta1_Power, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                switch (arg1){
                    case 0:
                        seleccion = (String) Pregunta1_Power[0];
                        break;

                    case 1:
                        seleccion=(String) Pregunta1_Power[arg1];
                        break;

                        case 2:
                        seleccion = (String) Pregunta1_Power[arg1];
                        break;
                }
            }
        }).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(seleccion == Pregunta1_Power[0]){
                    Toast.makeText(getActivity(),"Correcto",Toast.LENGTH_SHORT).show();
                }
                if(seleccion == Pregunta1_Power[1]){
                    Toast.makeText(getActivity(),"Incorrecto",Toast.LENGTH_SHORT).show();
                }
                if(seleccion == Pregunta1_Power[2]){
                    Toast.makeText(getActivity(),"Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
        /////////////////////////////////////////Pregunta2/////////////////////////////////////////////////////
        return preguntas.create();



    }
}
