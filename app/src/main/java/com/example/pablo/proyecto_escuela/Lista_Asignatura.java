package com.example.pablo.proyecto_escuela;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pablo.proyecto_escuela.Entidades.ConexionSqLiteHelper;
import com.example.pablo.proyecto_escuela.Entidades.asignatura;
import com.example.pablo.proyecto_escuela.utilidades.utilidades;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class Lista_Asignatura extends AppCompatActivity {

    Spinner sp_RAsignatura;

    EditText et_RnombreAsignatura, et_RhorasAsignatura, et_RprofesorAsignatura;

    ArrayList<String> listaAsignatura;
    ArrayList<asignatura> asignaturaList;

    ConexionSqLiteHelper conn;

    Button bt_actualizar_asignatura, bt_eliminar_asignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asignatura);

        conn = new ConexionSqLiteHelper(getApplicationContext(), "BD_Escuela", null,1);

        sp_RAsignatura = (Spinner) findViewById(R.id.sp_RAsignatura);

        et_RnombreAsignatura = (EditText) findViewById(R.id.et_RnombreAsignatura);
        et_RhorasAsignatura = (EditText) findViewById(R.id.et_RhoraAsignatura);
        et_RprofesorAsignatura = (EditText) findViewById(R.id.et_RprofesorAsignatura);

        bt_actualizar_asignatura = (Button) findViewById(R.id.bt_actualizar_asignatura);
        bt_eliminar_asignatura = (Button) findViewById(R.id.bt_eliminar_asignatura);

        bt_actualizar_asignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarAsignatura();
            }
        });

        bt_eliminar_asignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarAsignatura();
            }
        });

        consultarLístaAsignatura();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (getApplicationContext(), android.R.layout.simple_spinner_item, listaAsignatura);

        sp_RAsignatura.setAdapter(adaptador);

        sp_RAsignatura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position !=0){
                    et_RnombreAsignatura.setText(asignaturaList.get(position -1).getNombre_asignatura());
                    et_RhorasAsignatura.setText(asignaturaList.get(position -1).getHoras_asignatura());
                    et_RprofesorAsignatura.setText(asignaturaList.get(position -1).getProfesor_asignatura());
                }else{
                    et_RnombreAsignatura.setText("");
                    et_RhorasAsignatura.setText("");
                    et_RprofesorAsignatura.setText("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }




    private void consultarLístaAsignatura() {
        SQLiteDatabase db = conn.getReadableDatabase();

        asignatura asignatura = null;

        asignaturaList = new ArrayList<asignatura>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_ASIGNATURA, null);

        while (cursor.moveToNext()){
            asignatura = new asignatura();
            asignatura.setNombre_asignatura(cursor.getString(1));
            asignatura.setHoras_asignatura(cursor.getString(2));
            asignatura.setProfesor_asignatura(cursor.getString(3));

            asignaturaList.add(asignatura);
        }

        obtenerLista();

    }

    private void obtenerLista() {

        listaAsignatura = new ArrayList<String>();
        listaAsignatura.add("Seleccione...");

        for(int i=0; i < asignaturaList.size(); i++){
            listaAsignatura.add(asignaturaList.get(i).getNombre_asignatura());
        }


    }

    private void actualizarAsignatura() {
        SQLiteDatabase db = conn.getWritableDatabase();

        String[] parametros = {et_RnombreAsignatura.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NOMBRE_ASIGNATURA, et_RnombreAsignatura.getText().toString());
        valores.put(utilidades.CAMPO_HORAS_ASIGNATURA, et_RhorasAsignatura.getText().toString());
        valores.put(utilidades.CAMPO_PROFESOR_ASIGNATURA, et_RprofesorAsignatura.getText().toString());

        db.update(utilidades.TABLA_ASIGNATURA, valores, utilidades.CAMPO_NOMBRE_ASIGNATURA+"=?", parametros);

        Toast.makeText(getApplicationContext(), "ASIGNATURA ACTUALIZADA CON EXITO!!!", Toast.LENGTH_LONG).show();

        et_RnombreAsignatura.setText("");
        et_RhorasAsignatura.setText("");
        et_RprofesorAsignatura.setText("");
    }

    private void eliminarAsignatura() {

        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {et_RnombreAsignatura.getText().toString()};

        db.delete(utilidades.TABLA_ASIGNATURA, utilidades.CAMPO_NOMBRE_ASIGNATURA+"=?", parametros);

        et_RnombreAsignatura.setText("");
        et_RhorasAsignatura.setText("");
        et_RprofesorAsignatura.setText("");

        db.close();
    }

    public void onClick(View view){
        Intent intento = null;

        switch (view.getId()){
            case R.id.bt_registrar_asignatura:
                intento = new Intent(Lista_Asignatura.this, Registro_Asignatura.class);
                break;
        }

        if (intento != null){
            startActivity(intento);
        }

    }

}
















