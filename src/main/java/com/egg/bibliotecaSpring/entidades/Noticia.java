package com.egg.bibliotecaSpring.entidades;


import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
//@Table(name = "noticias")
@Data
public class Noticia implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long idNoticia;

    @NotNull
    private String titulo;
    @NotNull
    private String resumen;
    @NotNull
    private String cuerpo;

    @OneToOne
    private Imagen imagen;

    @Temporal(TemporalType.DATE)
    private Date fecha;


}