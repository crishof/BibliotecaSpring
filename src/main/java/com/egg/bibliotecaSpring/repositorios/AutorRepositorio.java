package com.egg.bibliotecaSpring.repositorios;

import com.egg.bibliotecaSpring.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
}
