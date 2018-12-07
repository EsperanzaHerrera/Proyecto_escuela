package com.example.pablo.proyecto_escuela;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.pablo.proyecto_escuela.Entidades.ConexionSqLiteHelper;

public class Seleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        //ConexionSqLiteHelper conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);
    }

    public void onClick (View view){

        Intent miIntento = null;

        switch (view.getId()){
            case R.id.bt_Alumnos:
                miIntento = new Intent(Seleccion.this, Lista_Alumnos.class);
                break;
            case R.id.bt_profesores:
                miIntento = new Intent(Seleccion.this, Lista_Profesor.class);
                break;
            case R.id.bt_salas:
                miIntento = new Intent(Seleccion.this, Lista_Salas.class);
                break;
            case R.id.bt_asignatura:
                miIntento = new Intent(Seleccion.this, Lista_Asignatura.class);
                break;
            case R.id.bt_deficiencia:
                miIntento = new Intent(Seleccion.this, Lista_Deficiencia.class);
        }

        if (miIntento != null){
            startActivity(miIntento);
        }
    }
}
