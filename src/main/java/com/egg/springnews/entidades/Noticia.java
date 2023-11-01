package com.egg.springnews.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "noticias")
@Getter
@Setter
@NoArgsConstructor
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

    @Temporal(TemporalType.DATE)
    private LocalDate fecha;


}