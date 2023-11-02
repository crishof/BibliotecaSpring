package com.egg.springnews.controladores;

import com.egg.springnews.entidades.Noticia;
import com.egg.springnews.servicios.NoticiaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;


//    @GetMapping("/agregar")
//    public String agregar(Noticia noticia) {
//        System.out.println("Ejecutando el metodo agregar");
//        return "modificar";
//    }

//    @PostMapping("/guardar")
//    public String guardar(@Valid Noticia noticia, Errors errores) {
//        System.out.println("Ejecutando el metodo guardar");
//        if (errores.hasErrors()) {
//            return "modificar";
//        }
//        noticiaServicio.guardar(noticia);
//        return "redirect:/";
//    }

    //@GetMapping("/editar/{idNoticia}") PASA A QUERY PARAM
//    @GetMapping("/editar")
//    public String editar(Noticia noticia, Model model) {
//        System.out.println("Ejecutando el metodo editar");
//        noticia = noticiaServicio.encontrarNoticia(noticia);
//        model.addAttribute("noticia", noticia);
//        return "modificar";
//    }

//    @GetMapping("/eliminar")
//    public String eliminar(Noticia noticia) {
//        System.out.println("Ejecutando el metodo eliminar");
//        noticiaServicio.eliminarNoticia(noticia);
//        return "redirect:/";
//    }
}
