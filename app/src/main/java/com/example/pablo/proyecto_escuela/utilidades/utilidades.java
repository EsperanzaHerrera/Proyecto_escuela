package com.example.pablo.proyecto_escuela.utilidades;


public class utilidades {

    //constantes tabla usuario
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id_usuario";
    public static final String CAMPO_USUARIO = "nombre_usuario";
    public static final String CAMPO_PASS = "pass_usuario";
    public static final String CAMPO_EMAIL = "email_usuario";

    //contantes tabla Alumno
    public static final String TABLA_ALUMNO = "alumno";
    public static final String CAMPO_ID_ALUMNO = "id_alumno";
    public static final String CAMPO_NOMBRE_ALUMNO = "nombre_alumno";
    public static final String CAMPO_APELLIDO_ALUMNO = "apellido_alumno";
    public static final String CAMPO_RUT_ALUMNO = "rut_alumno";
    public static final String CAMPO_DIRECCION_ALUMNO = "direccion_alumno";
    public static final String CAMPO_TELEFONO_ALUMNO = "telefono_alumno";
    public static final String CAMPO_APODERADO_ALUMNO = "apoderado_alumno";
    public static final String CAMPO_MEDICACION_ALUMNO = "medicacion_alumno";

    //contantes tabla profesor
    public static final String TABLA_PROFESOR = "profesor";
    public static final String CAMPO_ID_PROFESOR = "id_profesor";
    public static final String CAMPO_NOMBRE_PROFESOR = "nombre_profesor";
    public static final String CAMPO_DIRECCION_PROFESOR = "direccion_profesor";
    public static final String CAMPO_TELEFONO_PROFESOR = "telefono_profesor";
    public static final String CAMPO_ESPECIALIDAD_PROFESOR = "especialidad_profesor";

    //contantes tabla sala
    public static final String TABLA_SALA = "sala";
    public static final String CAMPO_ID_SALA = "id_sala";
    public static final String CAMPO_NUEMRO_SALA = "numero_sala";
    public static final String CAMPO_CALEFACCION_SALA = "calefaccion_sala";
    public static final String CAMPO_PIZARRA_SALA = "pizarra_sala";
    public static final String CAMPO_DATASHOW_SALA = "datashow_sala";
    public static final String CAMPO_COMPUTADOR_SALA = "computador_sala";

    //constantes tabla asignatura
    public static final String TABLA_ASIGNATURA = "asignatura";
    public static final String CAMPO_ID_ASIGNATURA = "id_asignatura";
    public static final String CAMPO_NOMBRE_ASIGNATURA = "nombre_asignatura";
    public static final String CAMPO_HORAS_ASIGNATURA = "horas_asignatura";
    public static final String CAMPO_PROFESOR_ASIGNATURA = "profesor_asignatura";

    //constantes tabla deficiencia
    public static final String TABLA_DEFICIENCIA= "deficiencia";
    public static final String CAMPO_ID_DEFICIENCIA = "id_deficiencia";
    public static final String CAMPO_NOMBRE_DEFICIENCIA = "nombre_deficiencia";
    public static final String CAMPO_AGRESIVO_DEFICIENCIA = "agresivo_deficiencia";
    public static final String CAMPO_MEDICAMENTO_DEFICIENCIA = "medicamento_deficiencia";
    public static final String CAMPO_CRISIS_DEFICIENCIA = "crisis_deficiencia";
    public static final String CAMPO_DEPENDENCIA_DEFICIENCIA = "dependencia_deficiencia";


    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + "" + TABLA_USUARIO +
            " (" + CAMPO_ID + "" + " INTEGER PRIMARY KEY, " + CAMPO_USUARIO + " TEXT, " + CAMPO_PASS + " TEXT, "
            + CAMPO_EMAIL + " TEXT )";

    public static final String CREAR_TABLA_ALUMNO = "CREATE TABLE " + ""+TABLA_ALUMNO+
            " ("+CAMPO_ID_ALUMNO+ "" + " INTEGER PRIMARY KEY, " +CAMPO_NOMBRE_ALUMNO+ " TEXT, "
            +CAMPO_APELLIDO_ALUMNO+ " TEXT, " + CAMPO_RUT_ALUMNO + " TEXT, " +CAMPO_DIRECCION_ALUMNO + " TEXT, "
            +CAMPO_TELEFONO_ALUMNO+ " TEXT, " + CAMPO_APODERADO_ALUMNO + " TEXT, "
            +CAMPO_MEDICACION_ALUMNO+ " TEXT )";

    public static final String CREAR_TABLA_PROFESOR = "CREATE TABLE " + "" + TABLA_PROFESOR +
            " ("+ CAMPO_ID_PROFESOR + " INTEGER PRIMARY KEY, " + CAMPO_NOMBRE_PROFESOR + " TEXT, "
            + CAMPO_DIRECCION_PROFESOR + " TEXT, " + CAMPO_TELEFONO_PROFESOR + " TEXT, "
            + CAMPO_ESPECIALIDAD_PROFESOR + " TEXT )";

    public static final String CREAR_TABLA_SALA = "CREATE TABLE " + "" + TABLA_SALA +
            " (" + CAMPO_ID_SALA + " INTEGER PRIMARY KEY, " + CAMPO_NUEMRO_SALA + " TEXT, "
            + CAMPO_CALEFACCION_SALA + " TEXT, " + CAMPO_PIZARRA_SALA + " TEXT, "
            + CAMPO_DATASHOW_SALA + " TEXT, " + CAMPO_COMPUTADOR_SALA + " TEXT )";

    public static final String CREAR_TABLA_ASIGNATURA = "CREATE TABLE " + "" + TABLA_ASIGNATURA +
            "(" + CAMPO_ID_ASIGNATURA + " INTEGER PRIMARY KEY, " + CAMPO_NOMBRE_ASIGNATURA + " TEXT, "
            + CAMPO_HORAS_ASIGNATURA + " TEXT, " + CAMPO_PROFESOR_ASIGNATURA + " TEXT )";

    public static final String CREAR_TABLA_DEFICIENCIA = "CREATE TABLE " + "" + TABLA_DEFICIENCIA +
            "(" + CAMPO_ID_DEFICIENCIA + " INTEGER PRIMARY KEY, " + CAMPO_NOMBRE_DEFICIENCIA + " TEXT, "
            + CAMPO_AGRESIVO_DEFICIENCIA + " TEXT, " + CAMPO_MEDICAMENTO_DEFICIENCIA + " TEXT, "
            + CAMPO_CRISIS_DEFICIENCIA + "  TEXT, " + CAMPO_DEPENDENCIA_DEFICIENCIA + " TEXT )";

    }
