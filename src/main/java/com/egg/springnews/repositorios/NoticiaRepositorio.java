package com.egg.springnews.repositorios;

import com.egg.springnews.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepositorio extends JpaRepository<Noticia, Long> {
}
