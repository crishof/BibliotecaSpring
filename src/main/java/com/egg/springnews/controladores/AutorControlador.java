package com.egg.springnews.controladores;

import com.egg.springnews.excepciones.MiException;
import com.egg.springnews.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autor") //localhost:8080/autor
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;
    @GetMapping("/registrar") //localhost:8080/autor/registrar
    public String registrar(){
        return "autor_form";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo){
        System.out.println("nombre = " + nombre);

        try {
            autorServicio.crearAutor(nombre);

            modelo.put("exito","Autor registrado correctamente");
        } catch (MiException e) {

            modelo.put("error",e.getMessage());
            return "autor_form";
        }
        return "index";
    }


}
