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

public class Registro_Usuario extends AppCompatActivity {

    EditText et_nombre_usuario, et_contraseña, et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        et_nombre_usuario = (EditText) findViewById(R.id.et_nombre_usuario);
        et_contraseña = (EditText) findViewById(R.id.et_contraseña);
        et_email = (EditText) findViewById(R.id.et_email);
    }

    public void onClick (View view){

        registrarUsuario();
    }

    private void registrarUsuario() {

        ConexionSqLiteHelper conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_USUARIO, et_nombre_usuario.getText().toString());
        valores.put(utilidades.CAMPO_PASS, et_contraseña.getText().toString());
        valores.put(utilidades.CAMPO_EMAIL, et_email.getText().toString());

        Long idResultante = db.insert(utilidades.TABLA_USUARIO, utilidades.CAMPO_USUARIO, valores);

        Toast.makeText(getApplicationContext(), "Usuario guardado con exito ", Toast.LENGTH_LONG).show();

        et_nombre_usuario.setText("");
        et_contraseña.setText("");
        et_email.setText("");
    }
}
