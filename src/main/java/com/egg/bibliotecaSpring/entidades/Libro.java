package com.egg.bibliotecaSpring.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Libro {
    @Id
    private Long isbn;
    private String titulo;
    private Integer ejemplares;

    @Temporal(TemporalType.DATE)
    private Date alta;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editorial editorial;
}
