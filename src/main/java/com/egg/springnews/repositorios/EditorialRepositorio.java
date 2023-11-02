package com.egg.springnews.repositorios;

import com.egg.springnews.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {
}
