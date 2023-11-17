package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notificación {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenidoNotificacion;

    @ManyToOne
    private Tecnico tecnicoDestinatario;
    private String fechaEnvio;
}