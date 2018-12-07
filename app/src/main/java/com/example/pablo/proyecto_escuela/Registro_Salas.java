package com.example.pablo.proyecto_escuela;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.proyecto_escuela.Entidades.ConexionSqLiteHelper;
import com.example.pablo.proyecto_escuela.utilidades.utilidades;


public class Registro_Salas extends AppCompatActivity {

    EditText et_numero_sala, et_calefaccion_sala, et_pizarra_sala, et_datashow_sala, et_computador_sala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_salas);

        et_numero_sala = (EditText) findViewById(R.id.et_numero_sala);
        et_calefaccion_sala = (EditText) findViewById(R.id.et_calefaccion_sala);
        et_pizarra_sala = (EditText) findViewById(R.id.et_pizarra_sala);
        et_datashow_sala = (EditText) findViewById(R.id.et_datashow_sala);
        et_computador_sala = (EditText) findViewById(R.id.et_computador_sala);
    }

    public void onClick (View view){
        registrarSala();
    }

    private void registrarSala(){

        ConexionSqLiteHelper conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NUEMRO_SALA, et_numero_sala.getText().toString());
        valores.put(utilidades.CAMPO_CALEFACCION_SALA, et_calefaccion_sala.getText().toString());
        valores.put(utilidades.CAMPO_PIZARRA_SALA, et_pizarra_sala.getText().toString());
        valores.put(utilidades.CAMPO_DATASHOW_SALA, et_datashow_sala.getText().toString());
        valores.put(utilidades.CAMPO_COMPUTADOR_SALA, et_computador_sala.getText().toString());

        Long idResultante3 = db.insert(utilidades.TABLA_SALA, utilidades.CAMPO_NUEMRO_SALA, valores);

        Toast.makeText(getApplicationContext(), "Sala guardada con exito", Toast.LENGTH_LONG).show();

        et_numero_sala.setText("");
        et_calefaccion_sala.setText("");
        et_pizarra_sala.setText("");
        et_datashow_sala.setText("");
        et_computador_sala.setText("");

    }
}