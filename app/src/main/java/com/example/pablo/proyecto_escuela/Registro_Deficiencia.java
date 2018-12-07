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

public class Registro_Deficiencia extends AppCompatActivity {

    EditText et_nombre_deficiencia, et_agresivo_deficiencia, et_medicacion_deficiencia, et_crisis_deficiencia, et_dependencia_deficiencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_deficiencia);

        et_nombre_deficiencia = (EditText) findViewById(R.id.et_nombre_deficiencia);
        et_agresivo_deficiencia = (EditText) findViewById(R.id.et_agresivo_deficiencia);
        et_medicacion_deficiencia = (EditText) findViewById(R.id.et_medicacion_deficiencia);
        et_crisis_deficiencia = (EditText) findViewById(R.id.et_crisis_deficiencia);
        et_dependencia_deficiencia = (EditText) findViewById(R.id.et_dependencia_deficiencia);

    }

    public void onClick (View view){
        registrarDeficiencia();
    }

    public void registrarDeficiencia(){

        ConexionSqLiteHelper conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NOMBRE_DEFICIENCIA, et_nombre_deficiencia.getText().toString());
        valores.put(utilidades.CAMPO_AGRESIVO_DEFICIENCIA, et_agresivo_deficiencia.getText().toString());
        valores.put(utilidades.CAMPO_MEDICAMENTO_DEFICIENCIA, et_medicacion_deficiencia.getText().toString());
        valores.put(utilidades.CAMPO_CRISIS_DEFICIENCIA, et_crisis_deficiencia.getText().toString());
        valores.put(utilidades.CAMPO_DEPENDENCIA_DEFICIENCIA, et_dependencia_deficiencia.getText().toString());

        Long idResultante = db.insert(utilidades.TABLA_DEFICIENCIA, utilidades.CAMPO_NOMBRE_DEFICIENCIA, valores);

        Toast.makeText(getApplicationContext(), "Deficiencia guardada con exito", Toast.LENGTH_LONG).show();

        et_nombre_deficiencia.setText("");
        et_agresivo_deficiencia.setText("");
        et_medicacion_deficiencia.setText("");
        et_crisis_deficiencia.setText("");
        et_dependencia_deficiencia.setText("");

    }
}
