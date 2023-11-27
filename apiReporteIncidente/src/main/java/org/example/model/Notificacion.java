package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.example.service.EmailService;

@Entity
@Getter
@Setter
public class Notificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    private String tituloNotificacion;
    private String contenidoNotificacion;
    private boolean enviado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteDestinatario;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnicoDestinatario;


    private Date fechaEnvio;

    public void enviarCorreo(String destinatario, String asunto, String contenido)  {
        EmailService.enviarCorreo(destinatario,asunto,contenido);
    }
}
