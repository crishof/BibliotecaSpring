package com.egg.springnews.repositorios;


import com.egg.springnews.entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, String> {

}
