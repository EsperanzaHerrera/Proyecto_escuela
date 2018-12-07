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
import com.example.pablo.proyecto_escuela.Entidades.deficiencia;
import com.example.pablo.proyecto_escuela.Entidades.sala;
import com.example.pablo.proyecto_escuela.utilidades.utilidades;

import java.util.ArrayList;

public class Lista_Salas extends AppCompatActivity {

    Spinner sp_sala;

    EditText et_Rnumero_sala, et_Rcalefaccion_sala, et_Rpizarra_sala, et_Rdatashow_sala, et_Rcomputador_sala;

    ArrayList<String> listaSala;
    ArrayList<sala> salaList;

    ConexionSqLiteHelper conn;

    Button bt_actualizarS, bt_registrarS, bt_eliminarS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_salas);

        conn = new ConexionSqLiteHelper(getApplicationContext(), "BD_Escuela", null, 1);

        sp_sala = (Spinner) findViewById(R.id.sp_sala);

        et_Rnumero_sala =(EditText) findViewById(R.id.et_Rnumero_sala);
        et_Rcalefaccion_sala =(EditText) findViewById(R.id.et_Rcalefaccion_sala);
        et_Rpizarra_sala =(EditText) findViewById(R.id.et_Rpizarra_sala);
        et_Rdatashow_sala =(EditText) findViewById(R.id.et_Rdatashow_sala);
        et_Rcomputador_sala =(EditText) findViewById(R.id.et_Rcomputador_sala);

        bt_actualizarS =(Button) findViewById(R.id.bt_actualizarS);
        bt_registrarS =(Button) findViewById(R.id.bt_registrarS);
        bt_eliminarS =(Button) findViewById(R.id.bt_eliminarS);

        bt_actualizarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarSala();
            }
        });

        bt_eliminarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarSala();
            }
        });

        consultarListaSalas();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (getApplicationContext(), android.R.layout.simple_spinner_item, listaSala);

        sp_sala.setAdapter(adaptador);

        sp_sala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position !=0){

                    et_Rnumero_sala.setText(salaList.get(position -1).getNumero_sala());
                    et_Rcalefaccion_sala.setText(salaList.get(position -1).getCalefacccion_sala());
                    et_Rpizarra_sala.setText(salaList.get(position -1).getPizarra_sala());
                    et_Rdatashow_sala.setText(salaList.get(position -1).getDatashow_sala());
                    et_Rcomputador_sala.setText(salaList.get(position -1).getComputador_sala());

                }else{

                    et_Rnumero_sala.setText("");
                    et_Rcalefaccion_sala.setText("");
                    et_Rpizarra_sala.setText("");
                    et_Rdatashow_sala.setText("");
                    et_Rcomputador_sala.setText("");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void consultarListaSalas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        sala sala = null;
        salaList = new ArrayList<sala>();

        Cursor cursor = db.rawQuery("SELECT * FROM " +utilidades.TABLA_SALA, null);

        while (cursor.moveToNext()) {

            sala = new sala();
            sala.setNumero_sala(cursor.getString(1));
            sala.setCalefacccion_sala(cursor.getString(2));
            sala.setPizarra_sala(cursor.getString(3));
            sala.setDatashow_sala(cursor.getString(4));
            sala.setComputador_sala(cursor.getString(5));


            salaList.add(sala);
        }
            obtenerLista();
    }

    private void obtenerLista(){

        listaSala = new ArrayList<String>();
        listaSala.add("Seleccione...");

        for (int i=0; i < salaList.size(); i++){
            listaSala.add(salaList.get(i).getNumero_sala());
        }
    }

    private void actualizarSala(){
        SQLiteDatabase db = conn.getWritableDatabase();

        String[] parametros = {et_Rnumero_sala.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NUEMRO_SALA, et_Rnumero_sala.getText().toString());
        valores.put(utilidades.CAMPO_CALEFACCION_SALA, et_Rcalefaccion_sala.getText().toString());
        valores.put(utilidades.CAMPO_PIZARRA_SALA, et_Rpizarra_sala.getText().toString());
        valores.put(utilidades.CAMPO_DATASHOW_SALA, et_Rdatashow_sala.getText().toString());
        valores.put(utilidades.CAMPO_COMPUTADOR_SALA, et_Rcomputador_sala.getText().toString());

        db.update(utilidades.TABLA_SALA, valores, utilidades.CAMPO_NUEMRO_SALA+"=?", parametros);

        Toast.makeText(getApplicationContext(), "SALA ACTUALIZADA CON EXITO", Toast.LENGTH_LONG).show();

        et_Rnumero_sala.setText("");
        et_Rcalefaccion_sala.setText("");
        et_Rpizarra_sala.setText("");
        et_Rdatashow_sala.setText("");
        et_Rcomputador_sala.setText("");

    }

    private void eliminarSala(){

        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {et_Rnumero_sala.getText().toString()};

        db.delete(utilidades.TABLA_SALA, utilidades.CAMPO_NUEMRO_SALA+"=?", parametros);

        et_Rnumero_sala.setText("");
        et_Rcalefaccion_sala.setText("");
        et_Rpizarra_sala.setText("");
        et_Rdatashow_sala.setText("");
        et_Rcomputador_sala.setText("");

        db.close();

    }

    public void onClick(View view){
        Intent intento = null;

        switch (view.getId()){
            case R.id.bt_registrarS:
                intento = new Intent(Lista_Salas.this, Registro_Salas.class);
                break;
        }

        if (intento != null){
            startActivity(intento);
        }
    }

}
