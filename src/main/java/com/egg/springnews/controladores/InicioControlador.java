package com.egg.springnews.controladores;

import com.egg.springnews.entidades.Noticia;
import com.egg.springnews.servicios.NoticiaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InicioControlador {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        log.info("usuario que hizo login: " + user);
//        var noticias = noticiaService.listarNoticias();
        log.info("ejecutando el controlador Spring MVC");
//        model.addAttribute("noticias",noticias);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Noticia noticia){
        System.out.println("Ejecutando el metodo agregar");
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Noticia noticia, Errors errores){
        System.out.println("Ejecutando el metodo guardar");
        if(errores.hasErrors()){
            return "modificar";
        }
//        noticiaService.guardar(noticia);
        return "redirect:/";
    }

    //@GetMapping("/editar/{idNoticia}") PASA A QUERY PARAM
    @GetMapping("/editar")
    public String editar(Noticia noticia, Model model){
        System.out.println("Ejecutando el metodo editar");
//        noticia = noticiaService.encontrarNoticia(noticia);
        model.addAttribute("noticia",noticia);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Noticia noticia){
        System.out.println("Ejecutando el metodo eliminar");
//        noticiaService.eliminarNoticia(noticia);
        return "redirect:/";
    }
}
