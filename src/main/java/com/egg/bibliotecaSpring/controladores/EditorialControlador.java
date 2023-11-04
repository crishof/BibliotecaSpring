package com.egg.bibliotecaSpring.controladores;

import com.egg.bibliotecaSpring.entidades.Editorial;
import com.egg.bibliotecaSpring.excepciones.MiException;
import com.egg.bibliotecaSpring.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Editorial> editoriales = editorialServicio.listarEditoriales();

        modelo.addAttribute("editoriales", editoriales);

        return "editorial_list";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo) {

        modelo.put("editorial", editorialServicio.getOne(id));

        return "editorial_modificar";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String nombre, ModelMap modelo) {

        try {
            editorialServicio.modificarEditorial(nombre, id);

            return "redirect:../lista";
        } catch (MiException e) {

            modelo.put("error", e.getMessage());

            return "editorial_modificar";
        }
    }
}
