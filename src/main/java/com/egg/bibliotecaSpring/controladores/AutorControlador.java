package com.egg.bibliotecaSpring.controladores;

import com.egg.bibliotecaSpring.entidades.Autor;
import com.egg.bibliotecaSpring.excepciones.MiException;
import com.egg.bibliotecaSpring.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/autor") //localhost:8080/autor
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/registrar") //localhost:8080/autor/registrar
    public String registrar() {
        return "autor_form";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) {
        System.out.println("nombre = " + nombre);

        try {
            autorServicio.crearAutor(nombre);

            modelo.put("exito", "Autor registrado correctamente");
        } catch (MiException e) {

            modelo.put("error", e.getMessage());
            return "autor_form";
        }
        return "index";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Autor> autores = autorServicio.listarAutores();

        modelo.addAttribute("autores", autores);

        return "autor_list";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo) {

        modelo.put("autor", autorServicio.getOne(id));

        return "autor_modificar";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String nombre, ModelMap modelo) {

        try {
            autorServicio.modificarAutor(nombre, id);
            modelo.put("exito","Autor modificado con exito");

            return "redirect:../lista";
        } catch (MiException e) {

            modelo.put("error", e.getMessage());

            return "autor_modificar";

        }
    }

}
