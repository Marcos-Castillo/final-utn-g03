package org.example.model;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;

    private String descripcionProblema;
    private Date fechaReporte;
    private Date fechaPosibleResolucion;
    private String estadoIncidente;
    private int colchonHorasEstimadas;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_tipo_problema")
    private TipoProblema tipoProblema;
}
