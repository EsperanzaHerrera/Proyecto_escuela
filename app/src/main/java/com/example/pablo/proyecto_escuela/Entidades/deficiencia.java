package com.example.pablo.proyecto_escuela.Entidades;



public class deficiencia {

    private Integer id_deficiencia;
    private String  nombre_deficiencia;
    private String  agresivo_deficiencia;
    private String  medicamento_deficiencia;
    private String  crisis_deficiencia;
    private String  dependencia_deficiencia;

    public deficiencia() {
    }

    public deficiencia(Integer id_deficiencia, String nombre_deficiencia, String agresivo_deficiencia, String medicamento_deficiencia, String crisis_deficiencia, String dependencia_deficiencia) {
        this.id_deficiencia = id_deficiencia;
        this.nombre_deficiencia = nombre_deficiencia;
        this.agresivo_deficiencia = agresivo_deficiencia;
        this.medicamento_deficiencia = medicamento_deficiencia;
        this.crisis_deficiencia = crisis_deficiencia;
        this.dependencia_deficiencia = dependencia_deficiencia;
    }

    public Integer getId_deficiencia() {
        return id_deficiencia;
    }

    public void setId_deficiencia(Integer id_deficiencia) {
        this.id_deficiencia = id_deficiencia;
    }

    public String getNombre_deficiencia() {
        return nombre_deficiencia;
    }

    public void setNombre_deficiencia(String nombre_deficiencia) {
        this.nombre_deficiencia = nombre_deficiencia;
    }

    public String getAgresivo_deficiencia() {
        return agresivo_deficiencia;
    }

    public void setAgresivo_deficiencia(String agresivo_deficiencia) {
        this.agresivo_deficiencia = agresivo_deficiencia;
    }

    public String getMedicamento_deficiencia() {
        return medicamento_deficiencia;
    }

    public void setMedicamento_deficiencia(String medicamento_deficiencia) {
        this.medicamento_deficiencia = medicamento_deficiencia;
    }

    public String getCrisis_deficiencia() {
        return crisis_deficiencia;
    }

    public void setCrisis_deficiencia(String crisis_deficiencia) {
        this.crisis_deficiencia = crisis_deficiencia;
    }

    public String getDependencia_deficiencia() {
        return dependencia_deficiencia;
    }

    public void setDependencia_deficiencia(String dependencia_deficiencia) {
        this.dependencia_deficiencia = dependencia_deficiencia;
    }
}
