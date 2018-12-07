package com.example.pablo.proyecto_escuela.Entidades;


public class usuario {

    private Integer id_usuario;
    private String usuario;
    private String pass;

    public usuario(Integer id, String usuario, String pass) {
        this.id_usuario = id;
        this.usuario = usuario;
        this.pass = pass;
    }

    public Integer getId() {
        return id_usuario;
    }

    public void setId(Integer id) {
        this.id_usuario = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
