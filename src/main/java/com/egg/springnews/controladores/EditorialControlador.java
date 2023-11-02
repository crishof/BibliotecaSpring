package com.egg.springnews.controladores;

import com.egg.springnews.excepciones.MiException;
import com.egg.springnews.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editorial")
public class EditorialControlador {

    @Autowired
    EditorialServicio editorialServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "editorial_form";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) throws MiException {
        System.out.println("nombre = " + nombre);

        try {
            editorialServicio.crearEditorial(nombre);

            modelo.put("exito", "Editorial registrada correctamente");
        } catch (MiException e) {

            modelo.put("error", e.getMessage());
            return "editorial_form";
        }
        return "index";
    }
}
