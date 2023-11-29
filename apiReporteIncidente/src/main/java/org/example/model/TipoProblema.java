
package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class TipoProblema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProblema;

    @Column(name = "nombre_tipo_problema")
    private String nombreTipoProblema;

    @Column(name = "tiempo_maximo_resolucion")
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

    public void setEspecialidad(Especialidad especialidad) {
        if (this.especialidades == null){
            this.especialidades=new ArrayList<Especialidad>();
        }
        this.especialidades.add(especialidad);
    }
}