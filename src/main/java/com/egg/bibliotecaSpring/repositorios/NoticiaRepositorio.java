package com.egg.bibliotecaSpring.repositorios;

import com.egg.bibliotecaSpring.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepositorio extends JpaRepository<Noticia, Long> {
}
