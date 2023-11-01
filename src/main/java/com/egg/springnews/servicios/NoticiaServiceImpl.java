package com.egg.springnews.servicios;

import com.egg.springnews.entidades.Noticia;
import com.egg.springnews.repositorios.NoticiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticiaServiceImpl implements NoticiaService {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Noticia> listarNoticias() {
        return noticiaRepositorio.findAll();
    }

    @Override
    @Transactional
    public void guardar(Noticia noticia) {
        noticiaRepositorio.save(noticia);

    }

    @Override
    @Transactional
    public void eliminarNoticia(Noticia noticia) {
        noticiaRepositorio.delete(noticia);

    }

    @Override
    @Transactional(readOnly = true)
    public Noticia encontrarNoticia(Noticia noticia) {
        return noticiaRepositorio.findById(noticia.getIdNoticia()).orElse(null);
    }
}
