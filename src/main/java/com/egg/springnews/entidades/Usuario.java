package com.egg.springnews.entidades;

import com.egg.springnews.enumeraciones.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idUsuario;

//    @NotNull
    private String username;

//    @NotNull
    private String password;
//    @NotNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;
}
