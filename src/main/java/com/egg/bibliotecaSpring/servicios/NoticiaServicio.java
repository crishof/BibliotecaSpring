package com.egg.bibliotecaSpring.servicios;

import com.egg.bibliotecaSpring.entidades.Noticia;

import java.util.List;

public interface NoticiaServicio {

    List<Noticia> listarNoticias();

    void guardar(Noticia noticia);

    void eliminarNoticia(Noticia noticia);

    Noticia encontrarNoticia(Noticia noticia);
}
