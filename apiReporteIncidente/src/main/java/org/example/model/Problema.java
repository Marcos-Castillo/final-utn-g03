package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Problema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProblema;

    private String fechaPosibleResolucion;
    private String colchonHorasEstimadas;
    private String descripcionDetallada;

    @ManyToOne
    @JoinColumn(name = "id_tipo_problema")
    private TipoProblema tipoProblema;

    @ManyToOne
    @JoinColumn(name = "id_incidente")
    private Incidente incidenteRelacionado;


}
