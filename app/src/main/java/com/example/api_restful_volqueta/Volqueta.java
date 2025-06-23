package com.example.api_restful_volqueta;

import com.google.gson.annotations.SerializedName;

public class Volqueta {
    @SerializedName("id")
    private int id;

    @SerializedName("placa")
    private String placa;

    @SerializedName("estado")
    private String estado;

    // Constructor, Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}