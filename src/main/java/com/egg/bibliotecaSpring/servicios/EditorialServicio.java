package com.egg.bibliotecaSpring.servicios;

import com.egg.bibliotecaSpring.entidades.Editorial;
import com.egg.bibliotecaSpring.excepciones.MiException;
import com.egg.bibliotecaSpring.repositorios.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialServicio {

    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiException {

        validar(nombre);

        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditoriales() {

        var editoriales = new ArrayList<Editorial>();

        editoriales = (ArrayList<Editorial>) editorialRepositorio.findAll();

        return editoriales;
    }

    @Transactional
    public void modificarEditorial(String nombre, String id) throws MiException {

        validar(nombre);

        if (id.isEmpty() || id == null) {
            throw new MiException("El id no puede ser nulo o estar vacío");
        }
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Editorial editorial = respuesta.get();

            editorial.setNombre(nombre);

            editorialRepositorio.save(editorial);
        }
    }

    public Editorial getOne(String id) {
        return editorialRepositorio.getOne(id);
    }

    private void validar(String nombre) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede ser nulo");
        }
    }
}
