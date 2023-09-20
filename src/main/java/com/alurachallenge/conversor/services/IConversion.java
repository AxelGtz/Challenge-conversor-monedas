package com.alurachallenge.conversor.services;

import java.math.BigDecimal;
import java.util.List;

import com.alurachallenge.conversor.models.Moneda;

public interface IConversion {
    public List<Moneda> agregarMonedas();
    public List<String> agregarOpciones();
    public Moneda convertirMoneda(String opcion,BigDecimal valor);
}
