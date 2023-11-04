package com.egg.bibliotecaSpring.controladores;

import com.egg.bibliotecaSpring.entidades.Noticia;
import com.egg.bibliotecaSpring.servicios.NoticiaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/noticia")
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

        @GetMapping("/inicio")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        log.info("usuario que hizo login: " + user);
        var noticias = noticiaServicio.listarNoticias();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("noticias", noticias);
        return "inicioNoticias";
    }

    @GetMapping("/registrar")
    public String agregar(ModelMap modelo) {

        return "noticia_form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Noticia noticia, Errors errores) {
        System.out.println("Ejecutando el metodo guardar");
        if (errores.hasErrors()) {
            return "noticia_modificar";
        }
        noticiaServicio.guardar(noticia);
        return "redirect:/";
    }

    //@GetMapping("/editar/{idNoticia}") PASA A QUERY PARAM
    @GetMapping("/editar")
    public String editar(Noticia noticia, Model model) {
        System.out.println("Ejecutando el metodo editar");
        noticia = noticiaServicio.encontrarNoticia(noticia);
        model.addAttribute("noticia", noticia);
        return "noticia_modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Noticia noticia) {
        System.out.println("Ejecutando el metodo eliminar");
        noticiaServicio.eliminarNoticia(noticia);
        return "redirect:/";
    }
}
