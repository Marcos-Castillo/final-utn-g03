package org.example.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class TipoProblema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProblema;
    private String nombreTipoProblema;
    private String tiempoMaximoResolucion;

    @ManyToMany
    @JoinTable(name = "tipo_problema_especialidad",
            joinColumns = @JoinColumn(name = "id_tipo_problema"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades;

    @ManyToMany(mappedBy = "tiposProblema")
    private List<Servicio> servicios;

    @OneToMany(mappedBy = "tipoProblema")
    private List<Problema> problemas;


}
