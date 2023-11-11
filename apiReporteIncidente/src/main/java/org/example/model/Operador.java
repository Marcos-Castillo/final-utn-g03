package org.example.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperador;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String usuario;
    private String contrasena;
}
