package com.example.pablo.proyecto_escuela;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.proyecto_escuela.Entidades.ConexionSqLiteHelper;
import com.example.pablo.proyecto_escuela.utilidades.utilidades;

public class login extends AppCompatActivity {

    ConexionSqLiteHelper conn;
    EditText et_login;
    EditText et_contrasena;
    Intent intento2 = null;
    Button bt_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);

        et_login = (EditText) findViewById(R.id.et_login);
        et_contrasena = (EditText) findViewById(R.id.et_contrasena);
        bt_ingresar = (Button) findViewById(R.id.bt_ingresar);

        bt_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });

    }

    public void onClick(View view) {

        Intent intento = null;

        switch (view.getId()) {
            case R.id.bt_registrar:
                intento = new Intent(login.this, Registro_Usuario.class);
                break;
        }

        if (intento != null) {
            startActivity(intento);

        }

    }


    private void ingresar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {et_login.getText().toString()};
        String usr = null;

        Cursor cursor = db.rawQuery("SELECT " + utilidades.CAMPO_USUARIO + " FROM " + utilidades.TABLA_USUARIO +
                " WHERE " + utilidades.CAMPO_USUARIO + "=?", parametros);

        cursor.moveToNext();
        if (cursor.getString(0) != et_login.getText().toString()) {
            Intent intento2 = new Intent(login.this, Seleccion.class);
            startActivity(intento2);
        } else {
            Toast.makeText(getApplicationContext(), "!! EL USUARIO NO EXISTE ¡¡", Toast.LENGTH_LONG).show();
        }

    }

}


