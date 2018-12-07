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

public class Registro_Asignatura extends AppCompatActivity {

    EditText et_nombreAsignatura, et_horasAsignatura, et_profesorAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_asignatura);

        et_nombreAsignatura = (EditText) findViewById(R.id.et_nombreAsignatura);
        et_horasAsignatura = (EditText) findViewById(R.id.et_horasAsignatura);
        et_profesorAsignatura = (EditText) findViewById(R.id.et_profesorAsignatura);
    }

    public void onClick (View view){

        registrarAsignatura();

    }

    private void registrarAsignatura() {

        ConexionSqLiteHelper conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NOMBRE_ASIGNATURA, et_nombreAsignatura.getText().toString());
        valores.put(utilidades.CAMPO_HORAS_ASIGNATURA, et_horasAsignatura.getText().toString());
        valores.put(utilidades.CAMPO_PROFESOR_ASIGNATURA, et_profesorAsignatura.getText().toString());

        Long idResultante = db.insert(utilidades.TABLA_ASIGNATURA, utilidades.CAMPO_NOMBRE_ASIGNATURA, valores);

        Toast.makeText(getApplicationContext(), "Asignatura guardada con exito ", Toast.LENGTH_LONG).show();

        et_nombreAsignatura.setText("");
        et_horasAsignatura.setText("");
        et_profesorAsignatura.setText("");

    }

}
