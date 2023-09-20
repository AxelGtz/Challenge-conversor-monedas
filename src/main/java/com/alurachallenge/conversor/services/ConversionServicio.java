package com.alurachallenge.conversor.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alurachallenge.conversor.models.Moneda;

@Component("miPrimerServicio")
public class ConversionServicio implements IConversion {

    public List<Moneda> agregarMonedas() {
        return Arrays.asList(
                new Moneda("Peso Argentino", "ARS", new BigDecimal("1.0")),
                new Moneda("Dolar Estadounidense", "USD", new BigDecimal("350.0")),
                new Moneda("Euro", "EUR", new BigDecimal("373.82")),
                new Moneda("Libra", "GBP", new BigDecimal("436.28")),
                new Moneda("Yen", "JPY", new BigDecimal("2.37")),
                new Moneda("Won Coreano", "KRW", new BigDecimal("0.26")));
    }

    public List<String> agregarOpciones() {
        return Arrays.asList(
                ("De Pesos a Dólar"),
                ("De Pesos a Euro"),
                ("De Pesos a Libras"),
                ("De Pesos a Yen"),
                ("De Pesos a Won Coreano"),
                ("Dólar a Pesos"),
                ("Euro a Pesos"),
                ("Libras a Pesos"),
                ("Yen a Pesos"),
                ("Won Coreano a Pesos"));
    }

    public Moneda convertirMoneda(String opcion, BigDecimal valor) {
        List<Moneda> monedas = agregarMonedas();
        Moneda resultado = new Moneda();
        switch (opcion) {
            case "De Pesos a Dólar":
                resultado.setSiglas(monedas.get(1).getSiglas());
                resultado.setValor(valor.divide(monedas.get(1).getValor(), 2, RoundingMode.CEILING));
                break;
            case "De Pesos a Euro":
                resultado.setSiglas(monedas.get(2).getSiglas());
                resultado.setValor(valor.divide(monedas.get(2).getValor(), 2, RoundingMode.CEILING));
                break;
            case "De Pesos a Libras":
                resultado.setSiglas(monedas.get(3).getSiglas());
                resultado.setValor(valor.divide(monedas.get(3).getValor(), 2, RoundingMode.CEILING));
                break;
            case "De Pesos a Yen":
                resultado.setSiglas(monedas.get(4).getSiglas());
                resultado.setValor(valor.divide(monedas.get(4).getValor(), 2, RoundingMode.CEILING));
                ;
                break;
            case "De Pesos a Won Coreano":
                resultado.setSiglas(monedas.get(5).getSiglas());
                resultado.setValor(valor.divide(monedas.get(5).getValor(), 2, RoundingMode.CEILING));
                break;
            case "Dólar a Pesos":
                resultado.setSiglas(monedas.get(0).getSiglas());
                resultado.setValor(valor.multiply(monedas.get(1).getValor()));
                break;
            case "Euro a Pesos":
                resultado.setSiglas(monedas.get(0).getSiglas());
                resultado.setValor(valor.multiply(monedas.get(2).getValor()));
                break;
            case "Libras a Pesos":
                resultado.setSiglas(monedas.get(0).getSiglas());
                resultado.setValor(valor.multiply(monedas.get(3).getValor()));
                break;
            case "Yen a Pesos":
                resultado.setSiglas(monedas.get(0).getSiglas());
                resultado.setValor(valor.multiply(monedas.get(4).getValor()));
                break;
            case "Won Coreano a Pesos":
                resultado.setSiglas(monedas.get(0).getSiglas());
                resultado.setValor(valor.multiply(monedas.get(5).getValor()));
                break;
            default:
                break;
        }
        return resultado;
    }
}