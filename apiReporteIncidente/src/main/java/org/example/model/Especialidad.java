package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreEspecialidad;
}