package com.egg.springnews.controladores;

import com.egg.springnews.entidades.Usuario;
import com.egg.springnews.excepciones.MiException;
import com.egg.springnews.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/login")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password, @RequestParam String password2, ModelMap model) {

        try {
            usuarioService.registrar(nombre, email, password, password2);
            model.put("exito", "Usuario registrado correctamente");
            return "index.html";
        } catch (MiException e) {
            model.put("error", e.getMessage());
            model.put("nombre", nombre);
            model.put("email", email);
            return "login.html";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap model) {

        if (error != null) {
            model.put("error", "Usuario o contraseña inválidos");
        }
        return "login.html";


    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {

        Usuario logueado = (Usuario) session.getAttribute("usuarioSession");

        if ( logueado.getRol().toString().equals("ADMIN")){
            return "redirect:/admin/dashboard";
        }

        return "inicio.html";
    }
}
