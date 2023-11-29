
package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidad;

    @Column(name = "nombre_especialidad")
    private String nombreEspecialidad;

    @ManyToMany
    @JoinTable(name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "id_especialidad"),
            inverseJoinColumns = @JoinColumn(name = "id_tecnico"))
    private List<Tecnico> tecnicos;

    @ManyToMany(mappedBy = "especialidades")
    private List<TipoProblema> tiposProblema;
}
