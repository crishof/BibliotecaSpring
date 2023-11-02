package com.egg.springnews.servicios;

import com.egg.springnews.entidades.Autor;
import com.egg.springnews.excepciones.MiException;
import com.egg.springnews.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.criterion.Projections.id;

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

    private void validar(String nombre) throws MiException {
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre no puede ser nulo");
        }
    }
}
