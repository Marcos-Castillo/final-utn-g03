package org.example.model;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;

    private String fechaReporte;
    private String fechaPosibleResolucion;
    private String estadoIncidente;
    private int colchonHorasEstimadas;

    @ManyToOne
    private Tecnico tecnicoAsignado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "incidente")
    private List<Problema> problemas;

    public void confirmarIncidente(){}
    public void notificarTécnico(){}
}