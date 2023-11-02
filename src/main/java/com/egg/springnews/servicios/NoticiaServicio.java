package com.egg.springnews.servicios;

import com.egg.springnews.entidades.Noticia;

import java.util.List;

public interface NoticiaServicio {

    List<Noticia> listarNoticias();

    void guardar(Noticia noticia);

    void eliminarNoticia(Noticia noticia);

    Noticia encontrarNoticia(Noticia noticia);
}
