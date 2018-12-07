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
import com.example.pablo.proyecto_escuela.utilidades.utilidades;

import java.util.ArrayList;

public class Lista_Deficiencia extends AppCompatActivity {

    Spinner sp_deficiencia;

    EditText et_Ragresivo_deficiencia, et_Rmedicacion_deficiencia, et_Rcrisis_deficiencia, et_Rdependencia_deficiencia;

    ArrayList<String> listaDeficiencia;
    ArrayList<deficiencia> deficienciaList;

    ConexionSqLiteHelper conn;

    Button bt_actualizard, bt_registrard, bt_eliminard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_deficiencia);

        conn = new ConexionSqLiteHelper(getApplicationContext(), "BD_Escuela", null, 1);

        sp_deficiencia = (Spinner) findViewById(R.id.sp_deficiencia);

        et_Ragresivo_deficiencia =(EditText) findViewById(R.id.et_Ragresivo_deficiencia);
        et_Rmedicacion_deficiencia =(EditText) findViewById(R.id.et_Rmedicacion_deficiencia);
        et_Rcrisis_deficiencia =(EditText) findViewById(R.id.et_Rcrisis_deficiencia);
        et_Rdependencia_deficiencia =(EditText) findViewById(R.id.et_Rdependencia_deficiencia);

        bt_actualizard =(Button) findViewById(R.id.bt_actualizard);
        bt_registrard =(Button) findViewById(R.id.bt_registrard);
        bt_eliminard =(Button) findViewById(R.id.bt_eliminard);

        bt_actualizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDeficiencia();
            }
        });

        bt_eliminard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarDeficiencia();
            }
        });

        consultarListaDeficiencia();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (getApplicationContext(), android.R.layout.simple_spinner_item, listaDeficiencia);

        sp_deficiencia.setAdapter(adaptador);

        sp_deficiencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position !=0){

                    et_Ragresivo_deficiencia.setText(deficienciaList.get(position -1).getAgresivo_deficiencia());
                    et_Rmedicacion_deficiencia.setText(deficienciaList.get(position -1).getMedicamento_deficiencia());
                    et_Rcrisis_deficiencia.setText(deficienciaList.get(position -1).getCrisis_deficiencia());
                    et_Rdependencia_deficiencia.setText(deficienciaList.get(position -1).getDependencia_deficiencia());

                }else{

                    et_Ragresivo_deficiencia.setText("");
                    et_Rmedicacion_deficiencia.setText("");
                    et_Rcrisis_deficiencia.setText("");
                    et_Rdependencia_deficiencia.setText("");

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void consultarListaDeficiencia(){
        SQLiteDatabase db = conn.getReadableDatabase();

        deficiencia deficiencia = null;
        deficienciaList = new ArrayList<deficiencia>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+utilidades.TABLA_DEFICIENCIA, null);

        while (cursor.moveToNext()){

            deficiencia = new deficiencia();
            deficiencia.setAgresivo_deficiencia(cursor.getString(2));
            deficiencia.setMedicamento_deficiencia(cursor.getString(3));
            deficiencia.setCrisis_deficiencia(cursor.getString(4));
            deficiencia.setDependencia_deficiencia(cursor.getString(5));

            deficienciaList.add(deficiencia);
        }

        obtenerLista();
    }

    private void obtenerLista(){

        listaDeficiencia = new ArrayList<String>();
        listaDeficiencia.add("Seleccione...");

        for (int i=0; i < deficienciaList.size(); i++){
            listaDeficiencia.add(deficienciaList.get(i).getAgresivo_deficiencia());
        }
    }

    private void actualizarDeficiencia(){
        SQLiteDatabase db = conn.getWritableDatabase();

        String[] parametros = {et_Ragresivo_deficiencia.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_AGRESIVO_DEFICIENCIA, et_Ragresivo_deficiencia.getText().toString());
        valores.put(utilidades.CAMPO_MEDICAMENTO_DEFICIENCIA, et_Rmedicacion_deficiencia.getText().toString());
        valores.put(utilidades.CAMPO_CRISIS_DEFICIENCIA, et_Rcrisis_deficiencia.getText().toString());
        valores.put(utilidades.CAMPO_DEPENDENCIA_DEFICIENCIA, et_Rdependencia_deficiencia.getText().toString());

        db.update(utilidades.TABLA_DEFICIENCIA, valores, utilidades.CAMPO_AGRESIVO_DEFICIENCIA+"=?", parametros);

        Toast.makeText(getApplicationContext(), "DEFICIENCIA ACTUALIZADA CON EXITO", Toast.LENGTH_LONG).show();

        et_Ragresivo_deficiencia.setText("");
        et_Rmedicacion_deficiencia.setText("");
        et_Rcrisis_deficiencia.setText("");
        et_Rdependencia_deficiencia.setText("");

    }

    private void eliminarDeficiencia(){

        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {et_Ragresivo_deficiencia.getText().toString()};

        db.delete(utilidades.TABLA_DEFICIENCIA, utilidades.CAMPO_AGRESIVO_DEFICIENCIA+"=?", parametros);

        et_Ragresivo_deficiencia.setText("");
        et_Rmedicacion_deficiencia.setText("");
        et_Rcrisis_deficiencia.setText("");
        et_Rdependencia_deficiencia.setText("");

        db.close();

    }

    public void onClick(View view){
        Intent intento = null;

        switch (view.getId()){
            case R.id.bt_registrard:
                intento = new Intent(Lista_Deficiencia.this, Registro_Deficiencia.class);
                break;
        }

        if (intento != null){
            startActivity(intento);
        }
    }
}
