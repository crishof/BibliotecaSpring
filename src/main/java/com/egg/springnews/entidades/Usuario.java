package com.egg.springnews.entidades;

import com.egg.springnews.enumeraciones.Rol;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idUsuario;

    //    @NotNull
    private String nombre;

    //    @NotNull
    private String password;
    //    @NotNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToOne
    private Imagen imagen;
}
