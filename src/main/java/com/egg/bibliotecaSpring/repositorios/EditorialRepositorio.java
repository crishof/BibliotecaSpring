package com.egg.bibliotecaSpring.repositorios;

import com.egg.bibliotecaSpring.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {
}
