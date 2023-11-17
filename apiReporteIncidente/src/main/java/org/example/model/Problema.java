package org.example.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Problema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcionDetallada;

    @ManyToOne
    private TipoProblema tipoProblema;

    @ManyToOne
    private Incidente incidenteRelacionado;
}