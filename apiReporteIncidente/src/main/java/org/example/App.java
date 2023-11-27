package org.example;

import org.example.DAO.AbstractJpaDAO;
import org.example.DAO.ClienteDAO;
import org.example.DAO.EspecialidadDAO;
import org.example.config.DBConfig;
import org.example.model.*;
import org.example.service.RankingTecnicosService;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // Crea un nuevo cliente
        Cliente cliente = new Cliente();
        cliente.setRazonSocial("Empresa ABC");
        cliente.setCuit("123456789");
        cliente.setContactoPrincipal("John Doe");
        cliente.setTelefono("123-456-789");
        cliente.setEmail("john.doe@example.com");

        // Lógica para contratar un servicio
        Servicio servicio = new Servicio();  // Supongamos que ya tienes un servicio creado
        cliente.contratarServicio(servicio);

        // Lógica para abrir un incidente
        Incidente incidente = new Incidente();  // Supongamos que ya tienes un incidente creado
        incidente.setCliente(cliente);  // Asocia el incidente con el cliente
        // Puedes agregar más detalles al incidente según tus necesidades

        // Lógica para asignar un técnico al incidente
        Tecnico tecnico = Tecnico.builder()
                .id(1L)
                .nombre("John")
                .apellido("Doe")
                .fechaNacimiento(LocalDate.of(1990, 1, 1))
                .disponible(true)
                .build();
        tecnico.asignarIncidente(incidente);

        // Lógica para resolver el incidente
        tecnico.resolverIncidente(incidente);

        // Muestra los resultados del ranking
        RankingTecnicosService rankingService = new RankingTecnicosService();

        // a. Quién fue el técnico con más incidentes resueltos en los últimos 5 días
        Tecnico tecnicoMasIncidentes = rankingService.obtenerTecnicoMasIncidentesResueltosUltimosDias(5);
        System.out.println("Técnico con más incidentes resueltos en los últimos 5 días: " + tecnicoMasIncidentes.getNombre());

        // b. Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos 5 días
        Especialidad especialidadBuscada = new Especialidad();
        Tecnico tecnicoMasIncidentesEspecialidad = rankingService.obtenerTecnicoMasIncidentesEspecialidadUltimosDias(especialidadBuscada, 5);
        System.out.println("Técnico con más incidentes resueltos en la especialidad " + especialidadBuscada.getNombreEspecialidad() + " en los últimos 5 días: " + tecnicoMasIncidentesEspecialidad.getNombre());

        // c. Quién fue el técnico que más rápido resolvió los incidentes
        Tecnico tecnicoMasRapido = rankingService.obtenerTecnicoMasRapido();
        System.out.println("Técnico que más rápido resolvió incidentes: " + tecnicoMasRapido.getNombre());
    }
}

