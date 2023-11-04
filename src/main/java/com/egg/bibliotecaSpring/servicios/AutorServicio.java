package com.egg.bibliotecaSpring.servicios;

import com.egg.bibliotecaSpring.entidades.Autor;
import com.egg.bibliotecaSpring.excepciones.MiException;
import com.egg.bibliotecaSpring.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {

    @Autowired
    AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiException {

        validar(nombre);

        Autor autor = new Autor();

        autor.setNombre(nombre);

        autorRepositorio.save(autor);
    }

    public List<Autor> listarAutores() {

        var autores = new ArrayList<Autor>();

        autores = (ArrayList<Autor>) autorRepositorio.findAll();

        return autores;
    }

    @Transactional
    public void modificarAutor(String nombre, String id) throws MiException {

        validar(nombre);

        if(id.isEmpty() || id == null){
            throw new MiException("El id no puede ser nulo o estar vacio");
        }


        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Autor autor = respuesta.get();

            autor.setNombre(nombre);

            autorRepositorio.save(autor);
        }
    }

    public Autor getOne(String id){
        return autorRepositorio.getOne(id);
    }
    private void validar(String nombre) throws MiException {
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre no puede ser nulo");
        }
    }
}
