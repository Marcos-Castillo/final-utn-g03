package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String email;

    private String razonSocial;
    private String cuit;
    private String contactoPrincipal;

    @ManyToMany
    @JoinTable(name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> serviciosContratados;

    @OneToMany(mappedBy = "cliente")
    private List<Incidente> incidentesReportados;

    @OneToMany(mappedBy = "clienteDestinatario")
    private List<Notificacion> notificaciones;

    public void contratarServicio(Servicio servicio) {

        if (serviciosContratados == null) {
            serviciosContratados = new ArrayList<>();
        }
        serviciosContratados.add(servicio);
    }

    public void reportarIncidente(Incidente incidente) {
        if (incidentesReportados == null) {
            incidentesReportados = new ArrayList<>();
        }
        incidentesReportados.add(incidente);
        incidente.setCliente(this);
    }
}