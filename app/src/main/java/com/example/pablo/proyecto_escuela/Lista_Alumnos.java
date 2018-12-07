package com.example.pablo.proyecto_escuela;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.proyecto_escuela.Entidades.ConexionSqLiteHelper;
import com.example.pablo.proyecto_escuela.Entidades.alumno;
import com.example.pablo.proyecto_escuela.utilidades.utilidades;


import java.sql.Array;
import java.util.ArrayList;

public class Lista_Alumnos extends AppCompatActivity {

    Spinner sp_alumno;

    EditText et_Rnombre_alumno, et_Rapellido_alumno, et_Rrut_alumno, et_Rdireccion_alumno, et_Rtelefono_alumno,et_Rapoderado_alumno, et_Rmedicacion_alumno;

    ArrayList<String> listaAlumno;
    ArrayList<alumno> alumnoList;

    ConexionSqLiteHelper conn;

    Button bt_actualizar, bt_eliminar, bt_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumnos);

        conn = new ConexionSqLiteHelper(getApplicationContext(), "BD_Escuela",null,1);

        sp_alumno = (Spinner) findViewById(R.id.sp_alumno);

        et_Rnombre_alumno = (EditText) findViewById(R.id.et_Rnombre_alumno);
        et_Rapellido_alumno = (EditText) findViewById(R.id.et_Rapellido_alumno);
        et_Rrut_alumno = (EditText) findViewById(R.id.et_Rrut_alumno);
        et_Rdireccion_alumno = (EditText) findViewById(R.id.et_Rdireccion_alumno);
        et_Rtelefono_alumno = (EditText) findViewById(R.id.et_Rtelefono_alumno);
        et_Rapoderado_alumno = (EditText) findViewById(R.id.et_Rapoderado_alumno);
        et_Rmedicacion_alumno = (EditText) findViewById(R.id.et_Rmedicacion_alumno);

        bt_registrar = (Button) findViewById(R.id.bt_registrar);
        bt_actualizar = (Button) findViewById(R.id.bt_actualizar);
        bt_eliminar = (Button) findViewById(R.id.bt_eliminar);



        bt_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarAlumno();
            }
        });

        bt_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarAlumno();
            }
        });


        consultarListaAlumno();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (getApplicationContext(), android.R.layout.simple_spinner_item, listaAlumno);

        sp_alumno.setAdapter(adaptador);

        sp_alumno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position !=0){

                    et_Rnombre_alumno.setText(alumnoList.get(position -1).getNombre_alumno());
                    et_Rapellido_alumno.setText(alumnoList.get(position -1).getApellido_alumno());
                    et_Rrut_alumno.setText(alumnoList.get(position -1).getRut_alumno());
                    et_Rdireccion_alumno.setText(alumnoList.get(position -1).getDireccion_alumno());
                    et_Rtelefono_alumno.setText(alumnoList.get(position -1).getTelefono_alumno());
                    et_Rapoderado_alumno.setText(alumnoList.get(position -1).getApoderado_alumno());
                    et_Rmedicacion_alumno.setText(alumnoList.get(position -1).getMedicacion_alumno());

                }else{
                    et_Rnombre_alumno.setText("");
                    et_Rapellido_alumno.setText("");
                    et_Rrut_alumno.setText("");
                    et_Rdireccion_alumno.setText("");
                    et_Rtelefono_alumno.setText("");
                    et_Rapoderado_alumno.setText("");
                    et_Rmedicacion_alumno.setText("");

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }



    private void consultarListaAlumno(){

        SQLiteDatabase db = conn.getReadableDatabase();

        alumno alumno = null;
        alumnoList = new ArrayList<alumno>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+utilidades.TABLA_ALUMNO, null);

        while(cursor.moveToNext()){

            alumno = new alumno();
            alumno.setNombre_alumno(cursor.getString(1));
            alumno.setApellido_alumno(cursor.getString(2));
            alumno.setRut_alumno(cursor.getString(3));
            alumno.setDireccion_alumno(cursor.getString(4));
            alumno.setTelefono_alumno(cursor.getString(5));
            alumno.setApoderado_alumno(cursor.getString(6));
            alumno.setMedicacion_alumno(cursor.getString(7));

            alumnoList.add(alumno);
        }
        
        obtenerLista();
        
    }

    private void obtenerLista() {

        listaAlumno = new ArrayList<String>();
        listaAlumno.add("Seleccione");

        for (int i=0; i < alumnoList.size(); i++){
            listaAlumno.add(alumnoList.get(i).getNombre_alumno()+" "+ alumnoList.get(i).getApellido_alumno());
        }
    }

    private void actualizarAlumno() {

        SQLiteDatabase db = conn.getWritableDatabase();

        String[] parametros = {et_Rnombre_alumno.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NOMBRE_ALUMNO, et_Rnombre_alumno.getText().toString());
        valores.put(utilidades.CAMPO_APELLIDO_ALUMNO, et_Rapellido_alumno.getText().toString());
        valores.put(utilidades.CAMPO_RUT_ALUMNO, et_Rrut_alumno.getText().toString());
        valores.put(utilidades.CAMPO_DIRECCION_ALUMNO, et_Rdireccion_alumno.getText().toString());
        valores.put(utilidades.CAMPO_TELEFONO_ALUMNO, et_Rtelefono_alumno.getText().toString());
        valores.put(utilidades.CAMPO_APODERADO_ALUMNO, et_Rapoderado_alumno.getText().toString());
        valores.put(utilidades.CAMPO_MEDICACION_ALUMNO, et_Rmedicacion_alumno.getText().toString());

        db.update(utilidades.TABLA_ALUMNO, valores, utilidades.CAMPO_NOMBRE_ALUMNO+"=?", parametros);

        Toast.makeText(getApplicationContext(), "ALUMNO ACTUALIZADO CON EXITO", Toast.LENGTH_LONG).show();

        et_Rnombre_alumno.setText("");
        et_Rapellido_alumno.setText("");
        et_Rrut_alumno.setText("");
        et_Rdireccion_alumno.setText("");
        et_Rtelefono_alumno.setText("");
        et_Rapoderado_alumno.setText("");
        et_Rmedicacion_alumno.setText("");
    }


    private void eliminarAlumno() {

        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {et_Rnombre_alumno.getText().toString()};

        db.delete(utilidades.TABLA_ALUMNO, utilidades.CAMPO_NOMBRE_ALUMNO+"=?", parametros);

        et_Rnombre_alumno.setText("");
        et_Rapellido_alumno.setText("");
        et_Rrut_alumno.setText("");
        et_Rdireccion_alumno.setText("");
        et_Rtelefono_alumno.setText("");
        et_Rapoderado_alumno.setText("");
        et_Rmedicacion_alumno.setText("");

        db.close();
    }

    public void onClick (View view){
        Intent intento1 = null;

        switch (view.getId()){
            case R.id.bt_registrar:
                intento1 = new Intent(Lista_Alumnos.this, Registro_alumnos.class);
                break;
        }

        if (intento1 != null){
            startActivity(intento1);
        }
    }
}