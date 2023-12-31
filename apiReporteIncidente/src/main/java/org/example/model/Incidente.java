
package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Incidente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;

    private LocalDate fechaReporte;
    private LocalDate fechaResolucion;

    @Enumerated(EnumType.STRING)
    private EstadoIncidente estado;
    private boolean cerrado;
    private boolean esComplejo;

    @ManyToOne
    @JoinColumn(name = "tecnico_asignado")
    private Tecnico tecnicoAsignado;

    @ManyToOne
    @JoinColumn(name = "tecnico_resuelve")
    private Tecnico tecnicoResuelve;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "incidenteRelacionado")
    private List<Problema> problemas;

    public void notificarTecnico(Tecnico tecnico) {
        Notificacion notificacion = new Notificacion();
        notificacion.setTituloNotificacion("Nuevo Incidente Asignado");
        notificacion.setContenidoNotificacion("Se le ha asignado un nuevo incidente para resolver.");
        notificacion.setEnviado(false);
        notificacion.setFechaEnvio(new Date());
        notificacion.setTecnicoDestinatario(tecnico);
        tecnico.getNotificaciones().add(notificacion);
    }

    public void setProblema(Problema problema) {
        if(this.problemas == null){
            this.problemas = new ArrayList<>();
        }
        this.problemas.add(problema);
    }
}
