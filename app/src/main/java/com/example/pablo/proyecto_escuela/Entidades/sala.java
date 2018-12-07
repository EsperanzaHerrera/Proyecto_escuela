package com.example.pablo.proyecto_escuela.Entidades;


public class sala {

    private Integer id_sala;
    private String numero_sala;
    private String calefacccion_sala;
    private String pizarra_sala;
    private String datashow_sala;
    private String computador_sala;

    public sala() {
    }

    public sala(Integer id_sala, String numero_sala, String calefacccion_sala, String pizarra_sala, String datashow_sala, String computador_sala) {
        this.id_sala = id_sala;
        this.numero_sala = numero_sala;
        this.calefacccion_sala = calefacccion_sala;
        this.pizarra_sala = pizarra_sala;
        this.datashow_sala = datashow_sala;
        this.computador_sala = computador_sala;
    }

    public Integer getId_sala() {
        return id_sala;
    }

    public void setId_sala(Integer id_sala) {
        this.id_sala = id_sala;
    }

    public String getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(String numero_sala) {
        this.numero_sala = numero_sala;
    }

    public String getCalefacccion_sala() {
        return calefacccion_sala;
    }

    public void setCalefacccion_sala(String calefacccion_sala) {
        this.calefacccion_sala = calefacccion_sala;
    }

    public String getPizarra_sala() {
        return pizarra_sala;
    }

    public void setPizarra_sala(String pizarra_sala) {
        this.pizarra_sala = pizarra_sala;
    }

    public String getDatashow_sala() {
        return datashow_sala;
    }

    public void setDatashow_sala(String datashow_sala) {
        this.datashow_sala = datashow_sala;
    }

    public String getComputador_sala() {
        return computador_sala;
    }

    public void setComputador_sala(String computador_sala) {
        this.computador_sala = computador_sala;
    }
}

