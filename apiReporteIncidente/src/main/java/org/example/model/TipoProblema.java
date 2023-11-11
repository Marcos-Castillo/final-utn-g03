package org.example.model;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
public class TipoProblema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProblema;

    private String nombreTipoProblema;
    private int tiempoMaximoResolucion;

    @OneToOne(mappedBy = "tipoProblema")
    private Incidente incidente;
}
