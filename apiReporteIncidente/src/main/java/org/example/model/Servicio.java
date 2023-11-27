
package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;

    private String nombreServicio;
    private String descripcionServicio;

    @ManyToMany
    @JoinTable(name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "id_servicio"),
            inverseJoinColumns = @JoinColumn(name = "id_cliente"))
    private List<Cliente> clientes;

    @ManyToMany
    @JoinTable(name = "servicio_tipo_problema",
            joinColumns = @JoinColumn(name = "id_servicio"),
            inverseJoinColumns = @JoinColumn(name = "id_tipo_problema"))
    private List<TipoProblema> tiposProblema;


}
