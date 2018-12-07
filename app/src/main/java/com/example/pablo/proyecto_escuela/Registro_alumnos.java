package com.example.pablo.proyecto_escuela;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.proyecto_escuela.Entidades.ConexionSqLiteHelper;
import com.example.pablo.proyecto_escuela.utilidades.utilidades;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Registro_alumnos extends AppCompatActivity {

    EditText et_nombrealumno, et_apellidoalumno, et_Rutalumno, et_direccionalumno,
             et_telefonoalumno, et_apoderadoalumno, et_medicamentoalumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumnos);

        //AdView mAdView = findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        et_nombrealumno = (EditText) findViewById(R.id.et_nombrealumno);
        et_apellidoalumno = (EditText) findViewById(R.id.et_apellidoalumno);
        et_Rutalumno = (EditText) findViewById(R.id.et_Rutalumno);
        et_direccionalumno = (EditText) findViewById(R.id.et_direccionalumno);
        et_telefonoalumno = (EditText) findViewById(R.id.et_telefonoalumno);
        et_apoderadoalumno = (EditText) findViewById(R.id.et_apoderadoalumno);
        et_medicamentoalumno = (EditText) findViewById(R.id.et_medicamentoalumno);

    }

    public void onClick(View view){
        
        registrarAlumnos();
    }

    private void registrarAlumnos() {

        ConexionSqLiteHelper conn = new ConexionSqLiteHelper(this, "BD_Escuela", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(utilidades.CAMPO_NOMBRE_ALUMNO, et_nombrealumno.getText().toString());
        valores.put(utilidades.CAMPO_APELLIDO_ALUMNO, et_apellidoalumno.getText().toString());
        valores.put(utilidades.CAMPO_RUT_ALUMNO, et_Rutalumno.getText().toString());
        valores.put(utilidades.CAMPO_DIRECCION_ALUMNO, et_direccionalumno.getText().toString());
        valores.put(utilidades.CAMPO_TELEFONO_ALUMNO, et_telefonoalumno.getText().toString());
        valores.put(utilidades.CAMPO_APODERADO_ALUMNO, et_apoderadoalumno.getText().toString());
        valores.put(utilidades.CAMPO_MEDICACION_ALUMNO, et_medicamentoalumno.getText().toString());

        Long idResultante = db.insert(utilidades.TABLA_ALUMNO, utilidades.CAMPO_NOMBRE_ALUMNO, valores);

        Toast.makeText(getApplicationContext(), "Alumno guardado con exito ", Toast.LENGTH_LONG).show();

        et_nombrealumno.setText("");
        et_apellidoalumno.setText("");
        et_Rutalumno.setText("");
        et_direccionalumno.setText("");
        et_telefonoalumno.setText("");
        et_apoderadoalumno.setText("");
        et_medicamentoalumno.setText("");

    }

}
