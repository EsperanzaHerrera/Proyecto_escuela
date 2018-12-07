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

public class Registro_Profesor  extends AppCompatActivity {

    EditText et_nombreprofe, et_direccionprofe, et_telefonoprofe, et_especialidadProfe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_profesor);

        et_nombreprofe = (EditText) findViewById(R.id.et_nombreprofe);
        et_direccionprofe = (EditText) findViewById(R.id.et_direccionprofe);
        et_telefonoprofe = (EditText) findViewById(R.id.et_telefonoprofe);
        et_especialidadProfe = (EditText) findViewById(R.id.et_especialidadProfe);
    }

    public void onClick(View view){

        registrarProfesor();

    }

    private void registrarProfesor() {

        ConexionSqLiteHelper conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NOMBRE_PROFESOR, et_nombreprofe.getText().toString());
        valores.put(utilidades.CAMPO_DIRECCION_PROFESOR, et_direccionprofe.getText().toString());
        valores.put(utilidades.CAMPO_TELEFONO_PROFESOR, et_telefonoprofe.getText().toString());
        valores.put(utilidades.CAMPO_ESPECIALIDAD_PROFESOR, et_especialidadProfe.getText().toString());

        Long idResultante = db.insert(utilidades.TABLA_PROFESOR, utilidades.CAMPO_NOMBRE_PROFESOR, valores);

        Toast.makeText(getApplicationContext(), "Profesor guardado con exito ", Toast.LENGTH_LONG).show();

        et_nombreprofe.setText("");
        et_direccionprofe.setText("");
        et_telefonoprofe.setText("");
        et_especialidadProfe.setText("");

    }
}
