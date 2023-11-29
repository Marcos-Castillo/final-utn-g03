
package org.example.model;

import lombok.*;

import javax.enterprise.inject.New;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tecnico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String email;

    @ManyToMany(mappedBy = "tecnicos")
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnicoAsignado")
    private List<Incidente> incidentesAsignados = new ArrayList<>();

    @OneToMany(mappedBy = "tecnicoResuelve")
    private List<Incidente> incidentesResueltos = new ArrayList<>();

    @OneToMany(mappedBy = "tecnicoDestinatario")
    private List<Notificacion> notificaciones;

    private String medioDeNotificacion;
    private boolean disponible = true;


    public void asignarIncidente(Incidente incidente) {
        if (incidentesAsignados == null) {
            incidentesAsignados = new ArrayList<>();
        }
        if (disponible) {
            incidente.setTecnicoAsignado(this);
            incidentesAsignados.add(incidente);
        } else {
            throw new IllegalStateException("El técnico no está disponible para asignar incidentes.");
        }
    }

    public void resolverIncidente(Incidente incidente) {
        if (incidentesResueltos == null) {
            incidentesResueltos = new ArrayList<>();
        }
        if (incidentesAsignados.contains(incidente)) {
            incidente.setTecnicoResuelve(this);
            incidente.setEstado(EstadoIncidente.RESUELTO);
            incidente.setCerrado(true);
            incidente.setFechaResolucion(LocalDate.now());
            incidentesResueltos.add(incidente);

        } else {
            throw new IllegalArgumentException("El técnico no puede resolver un incidente que no le fue asignado.");
        }


    }

    public void setEspecialidad(Especialidad especialidad) {
        if (this.especialidades ==null){
            this.especialidades=new ArrayList<>();
        }
        this.especialidades.add(especialidad);
    }
}