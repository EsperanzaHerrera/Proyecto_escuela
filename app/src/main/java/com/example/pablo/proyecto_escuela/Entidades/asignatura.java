package com.example.pablo.proyecto_escuela.Entidades;



public class asignatura {

    private Integer id_asignatura;
    private String  nombre_asignatura;
    private String horas_asignatura;
    private String  profesor_asignatura;

    public asignatura() {
        this.id_asignatura = id_asignatura;
        this.nombre_asignatura = nombre_asignatura;
        this.horas_asignatura = horas_asignatura;
        this.profesor_asignatura = profesor_asignatura;
    }

    public Integer getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Integer id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public String getHoras_asignatura() {
        return horas_asignatura;
    }

    public void setHoras_asignatura(String horas_asignatura) {
        this.horas_asignatura = horas_asignatura;
    }

    public String getProfesor_asignatura() {
        return profesor_asignatura;
    }

    public void setProfesor_asignatura(String profesor_asignatura) {
        this.profesor_asignatura = profesor_asignatura;
    }
}
