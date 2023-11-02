package com.egg.springnews.controladores;

import com.egg.springnews.entidades.Autor;
import com.egg.springnews.entidades.Editorial;
import com.egg.springnews.excepciones.MiException;
import com.egg.springnews.servicios.AutorServicio;
import com.egg.springnews.servicios.EditorialServicio;
import com.egg.springnews.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/libro")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping("/registrar")
    public String registrar(ModelMap modelo) {

        List<Autor> autores = autorServicio.listarAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales();

        modelo.put("autores", autores);
        modelo.put("editoriales", editoriales);

        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo,
                           @RequestParam(required = false) Integer ejemplares, @RequestParam String idAutor,
                           @RequestParam String idEditorial, ModelMap modelo) throws MiException {

        try {
            libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);

            modelo.put("exito", "Libro cargado correctamente");

        } catch (MiException e) {
            List<Autor> autores = autorServicio.listarAutores();
            List<Editorial> editoriales = editorialServicio.listarEditoriales();

            modelo.put("autores", autores);
            modelo.put("editoriales", editoriales);
            modelo.put("error", e.getMessage());

            return "libro_form.html";
        }
        return "index.html";
    }
}
