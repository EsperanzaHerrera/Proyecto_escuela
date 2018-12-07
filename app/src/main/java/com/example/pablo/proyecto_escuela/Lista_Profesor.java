package com.example.pablo.proyecto_escuela;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pablo.proyecto_escuela.Entidades.ConexionSqLiteHelper;
import com.example.pablo.proyecto_escuela.Entidades.profesor;
import com.example.pablo.proyecto_escuela.utilidades.utilidades;

import java.util.ArrayList;

public class Lista_Profesor extends AppCompatActivity {

    Spinner sp_profesor;
    EditText et_Rnombreprofe, et_Rdireccionprofe, et_Rtelefonoprofe, et_RespecialidadProfe;

    ArrayList<String> listaProfe;
    ArrayList<profesor> profeList;

    ConexionSqLiteHelper conn;

    Button bt_actuaizarp, bt_registrarp, bt_eliminarp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_profesor);

        conn = new ConexionSqLiteHelper(getApplicationContext(), "BD_Escuela", null, 1);

        sp_profesor = (Spinner) findViewById(R.id.sp_profesor);

        et_Rnombreprofe = (EditText) findViewById(R.id.et_Rnombreprofe);
        et_Rdireccionprofe = (EditText) findViewById(R.id.et_Rdireccionprofe);
        et_Rtelefonoprofe = (EditText) findViewById(R.id.et_Rtelefonoprofe);
        et_RespecialidadProfe = (EditText) findViewById(R.id.et_RespecialidadProfe);


        bt_actuaizarp = (Button) findViewById(R.id.bt_actuaizarp);
        bt_registrarp = (Button) findViewById(R.id.bt_registarp);
        bt_eliminarp = (Button) findViewById(R.id.bt_eliminarp);


        bt_actuaizarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actualizarProfesor();

            }
        });


        bt_eliminarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eliminarPreofesor();

            }
        });


        consultarListaProfesor();


        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (getApplicationContext(), android.R.layout.simple_spinner_item, listaProfe);

        sp_profesor.setAdapter(adaptador);

        sp_profesor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position !=0){

                    et_Rnombreprofe.setText(profeList.get(position -1).getNombre_profesor());
                    et_Rdireccionprofe.setText(profeList.get(position -1).getDireccion_profesor());
                    et_Rtelefonoprofe.setText(profeList.get(position -1).getTelefono_profesor());
                    et_RespecialidadProfe.setText(profeList.get(position -1).getEspecialidad_profesor());

                }else{

                    et_Rnombreprofe.setText("");
                    et_Rdireccionprofe.setText("");
                    et_Rtelefonoprofe.setText("");
                    et_RespecialidadProfe.setText("");



                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void consultarListaProfesor(){

        SQLiteDatabase db = conn.getReadableDatabase();

        profesor profesor = null;
        profeList = new ArrayList<profesor>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+utilidades.TABLA_PROFESOR, null);

        while(cursor.moveToNext()){
            profesor = new profesor();
            profesor.setNombre_profesor(cursor.getString(1));
            profesor.setDireccion_profesor(cursor.getString(2));
            profesor.setTelefono_profesor(cursor.getString(3));
            profesor.setEspecialidad_profesor(cursor.getString(4));

            profeList.add(profesor);
        }

        obetnerLista();

    }

    private void obetnerLista(){
        listaProfe = new ArrayList<String>();
        listaProfe.add("Seleccione...");

        for (int i=0; i<profeList.size(); i++){
            listaProfe.add(profeList.get(i).getNombre_profesor());
        }
    }

    private void actualizarProfesor() {

        SQLiteDatabase db = conn.getWritableDatabase();

        String [] parametros = {et_Rnombreprofe.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NOMBRE_PROFESOR, et_Rnombreprofe.getText().toString());
        valores.put(utilidades.CAMPO_DIRECCION_PROFESOR, et_Rdireccionprofe.getText().toString());
        valores.put(utilidades.CAMPO_TELEFONO_PROFESOR, et_Rtelefonoprofe.getText().toString());
        valores.put(utilidades.CAMPO_ESPECIALIDAD_PROFESOR, et_RespecialidadProfe.getText().toString());

        db.update(utilidades.TABLA_PROFESOR, valores, utilidades.CAMPO_NOMBRE_PROFESOR+"=?", parametros);

        Toast.makeText(getApplicationContext(), "PROFESOR SCTUALIZADO CON EXITO ", Toast.LENGTH_LONG).show();

        et_Rnombreprofe.setText("");
        et_Rdireccionprofe.setText("");
        et_Rtelefonoprofe.setText("");
        et_RespecialidadProfe.setText("");
    }

    private void eliminarPreofesor(){

        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {et_Rnombreprofe.getText().toString()};
        db.delete(utilidades.TABLA_PROFESOR, utilidades.CAMPO_NOMBRE_PROFESOR+"=?", parametros);

        et_Rnombreprofe.setText("");
        et_Rdireccionprofe.setText("");
        et_Rtelefonoprofe.setText("");
        et_RespecialidadProfe.setText("");

        db.close();
    }

    public void onClick(View view){
        Intent intento = null;

        switch (view.getId()){
            case R.id.bt_registarp:
                intento = new Intent(Lista_Profesor.this, Registro_Profesor.class);
                break;
        }

        if (intento != null){
            startActivity(intento);
        }

    }

}
