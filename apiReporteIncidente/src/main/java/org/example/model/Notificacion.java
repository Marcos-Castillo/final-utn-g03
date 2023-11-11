package org.example.model;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    private String contenidoNotificacion;
    private Date fechaEnvio;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;
}
