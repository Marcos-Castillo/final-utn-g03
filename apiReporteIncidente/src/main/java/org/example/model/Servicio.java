package org.example.model;

import javax.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreServicio;
    private String descripcionServicio;

    @ManyToOne
    private Especialidad especialidad;
}
