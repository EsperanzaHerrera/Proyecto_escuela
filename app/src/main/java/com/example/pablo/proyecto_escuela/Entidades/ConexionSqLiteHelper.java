package com.example.pablo.proyecto_escuela.Entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pablo.proyecto_escuela.utilidades.utilidades;


public class ConexionSqLiteHelper extends SQLiteOpenHelper {

    public ConexionSqLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(utilidades.CREAR_TABLA_ALUMNO);
        db.execSQL(utilidades.CREAR_TABLA_PROFESOR);
        db.execSQL(utilidades.CREAR_TABLA_SALA);
        db.execSQL(utilidades.CREAR_TABLA_ASIGNATURA);
        db.execSQL(utilidades.CREAR_TABLA_DEFICIENCIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_ALUMNO);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_PROFESOR);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_SALA);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_ASIGNATURA);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_DEFICIENCIA);
        onCreate(db);

    }
}
