package com.alurachallenge.conversor.models;

import java.math.BigDecimal;

public class Moneda {
    private String nombre;
    private String siglas;
    private BigDecimal valor;

    public Moneda() {
    }

    public Moneda(String nombre, String siglas, BigDecimal valor) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
