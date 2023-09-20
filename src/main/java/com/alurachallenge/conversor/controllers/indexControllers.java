package com.alurachallenge.conversor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alurachallenge.conversor.models.DtoMoneda;
import com.alurachallenge.conversor.models.Moneda;
import com.alurachallenge.conversor.services.IConversion;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping()
public class indexControllers {

    // Para injectar un objeto que esta guardado en el contenedor de spring.\
    @Autowired
    @Qualifier("miPrimerServicio")
    private IConversion conversionService;

    @GetMapping()
    public String monedas(ModelMap model) {
        model.addAttribute("moneda", new DtoMoneda(null, null));
        return "conversion";
    }

    @PostMapping()
    public String convertir(@Validated DtoMoneda dtomoneda, ModelMap model) {
        Moneda resultado = conversionService.convertirMoneda(dtomoneda.opcionElegida(), dtomoneda.valor());
        model.addAttribute("opcionElegida", dtomoneda.opcionElegida());
        model.addAttribute("resultado", resultado.getValor());
        model.addAttribute("siglas", resultado.getSiglas());
        return "resultado";
    }

    @ModelAttribute("opciones")
    public List<String> opcionesConversion() {
        List<String> opciones = conversionService.agregarOpciones();
        return opciones;
    }

}
