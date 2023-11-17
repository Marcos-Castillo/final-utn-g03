package org.example.model;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreTipoProblema;
    private int tiempoMaximoResolucion;
}