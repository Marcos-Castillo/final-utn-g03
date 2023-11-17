package org.example.model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
@Entity
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnico;

    private String nombre;
    private String apellido;

    @ManyToMany
    @JoinTable(name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades;

    private String medioNotificacionPreferido;
    private int tiempoEstimadoResolucion;

    @OneToMany(mappedBy = "tecnico")
    private List<Incidente> incidentesAsignados;

    public void asignarIncidente(){}
    public void resolverIncidente(){}

}