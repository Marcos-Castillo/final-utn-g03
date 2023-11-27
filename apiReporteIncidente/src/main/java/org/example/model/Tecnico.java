package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
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
        private List<Incidente> incidentesAsignados;

        @OneToMany(mappedBy = "tecnicoResuelve")
        private List<Incidente> incidentesResueltos;

        @OneToMany(mappedBy = "tecnicoDestinatario")
        private List<Notificacion> notificaciones;

        private String medioDeNotificacion;
        private boolean disponible;

        public void asignarIncidente(Incidente incidente) {
                if (disponible) {
                        incidente.setTecnicoAsignado(this);
                        incidentesAsignados.add(incidente);
                } else {
                        throw new IllegalStateException("El técnico no está disponible para asignar incidentes.");
                }
        }

        public void resolverIncidente(Incidente incidente) {
                if (incidentesAsignados.contains(incidente)) {
                        incidente.setTecnicoResuelve(this);
                        incidente.setEstado(EstadoIncidente.RESUELTO);
                        incidentesResueltos.add(incidente);
                } else {
                        throw new IllegalArgumentException("El técnico no puede resolver un incidente que no le fue asignado.");
                }
        }

}
