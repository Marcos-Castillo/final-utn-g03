package org.example.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String razonSocial;
    private String cuit;
    private String contactoPrincipal;
    private String telefono;
    private String email;

    @ManyToMany
    @JoinTable(name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> serviciosContratados;

    @OneToMany(mappedBy = "cliente")
    private List<Incidente> incidentesReportados;

    public void contratarServicio(){}
    public void reportarIncidente(){}
}