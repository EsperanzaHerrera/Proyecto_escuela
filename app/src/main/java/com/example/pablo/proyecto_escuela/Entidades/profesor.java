package com.example.pablo.proyecto_escuela.Entidades;



public class profesor {

    private String  nombre_profesor;
    private String  direccion_profesor;
    private String  telefono_profesor;
    private String  especialidad_profesor;

    public profesor(String nombre_profesor, String direccion_profesor, String telefono_profesor, String especialidad_profesor) {
        this.nombre_profesor = nombre_profesor;
        this.direccion_profesor = direccion_profesor;
        this.telefono_profesor = telefono_profesor;
        this.especialidad_profesor = especialidad_profesor;
    }

    public profesor() {
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getDireccion_profesor() {
        return direccion_profesor;
    }

    public void setDireccion_profesor(String direccion_profesor) {
        this.direccion_profesor = direccion_profesor;
    }

    public String getTelefono_profesor() {
        return telefono_profesor;
    }

    public void setTelefono_profesor(String telefono_profesor) {
        this.telefono_profesor = telefono_profesor;
    }

    public String getEspecialidad_profesor() {
        return especialidad_profesor;
    }

    public void setEspecialidad_profesor(String especialidad_profesor) {
        this.especialidad_profesor = especialidad_profesor;
    }
}
