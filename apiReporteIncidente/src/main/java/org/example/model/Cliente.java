package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "contacto_principal")
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