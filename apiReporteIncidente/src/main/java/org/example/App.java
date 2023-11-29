package org.example;

import org.example.config.DBConfig;
import org.example.controller.*;
import org.example.model.*;
import org.example.service.RankingTecnicosService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {


    public static void main(String[] args) {
        EntityManager  entityManager = DBConfig.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

        ServicioController servicioController = new ServicioController(entityManager);
        IncidenteController incidenteController = new IncidenteController(entityManager);
        ClienteController clienteController = new ClienteController(entityManager, servicioController);
        TecnicoController tecnicoController = new TecnicoController(entityManager);

        EspecialidadController especialidadController = new EspecialidadController(entityManager);
        TipoProblemaController tipoProblemaController = new TipoProblemaController(entityManager);

            System.out.println("#####################################");
            System.out.println("Crea los datos para pruebas");
        Especialidad especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("redes");
        especialidadController.crearEspecialidad(especialidad);
        TipoProblema tipoProblema =new TipoProblema();
        tipoProblema.setNombreTipoProblema("internet");
        tipoProblema.setEspecialidad(especialidad);
        tipoProblemaController.crearTipoProblema(tipoProblema);
        // Crea un nuevo cliente
        Cliente cliente = new Cliente();
        cliente.setRazonSocial("Empresa ABC");
        cliente.setCuit("123456789");
        cliente.setContactoPrincipal("John Doe");
        cliente.setTelefono("123-456-789");
        cliente.setEmail("john.doe@example.com");

        // Guarda el cliente antes de asociarle un servicio
        clienteController.crearCliente(cliente);

        // Crea un nuevo servicio
        Servicio servicio = new Servicio();
        servicio.setNombreServicio("internet");
        servicio.setTiposProblema(new ArrayList<>());

        // Guarda el servicio antes de asociarlo al cliente
        servicioController.crearServicio(servicio);

        // Lógica para contratar un servicio
        clienteController.contratarServicio(cliente, servicio);

        // Lógica para abrir un incidente
        Incidente incidente = new Incidente(null, LocalDate.now(), null, EstadoIncidente.ABIERTO, false, false, null, null, null, new ArrayList<Problema>());
        Problema problema = new Problema();
        problema.setTipoProblema(tipoProblema);
        incidente.setProblema(problema);
        incidente.setCliente(cliente);


        incidenteController.abrirIncidente(incidente);

        // Lógica para asignar un técnico al incidente
            Tecnico tecnico = new Tecnico();
            tecnico.setNombre("John");
            tecnico.setApellido("Doe");
            tecnico.setFechaNacimiento(LocalDate.of(1990, 1, 1));
            tecnico.setEspecialidad(especialidad);
            tecnico.setEmail("crreo@google.com");
            tecnico.setTelefono("123-456-789");
            tecnico.setDisponible(true);
            tecnicoController.crearTecnico(tecnico);

        tecnicoController.asignarIncidente(tecnico, incidente);

        // Lógica para resolver el incidente
        tecnicoController.resolverIncidente(tecnico, incidente);
            System.out.println("#####################################");
            System.out.println("Muestra los resultados del ranking");
        // Muestra los resultados del ranking
        RankingTecnicosService rankingService = new RankingTecnicosService(incidenteController.obtenerTodosLosIncidentes());
        // a. Quién fue el técnico con más incidentes resueltos en los últimos 5 días
        Tecnico tecnicoMasIncidentes = rankingService.obtenerTecnicoMasIncidentesResueltosUltimosDias(5);
        System.out.println("Técnico con más incidentes resueltos en los últimos 5 días: " + tecnicoMasIncidentes.getNombre());

        // b. Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos 5 días
        Especialidad especialidadBuscada = especialidad;
        Tecnico tecnicoMasIncidentesEspecialidad = rankingService.obtenerTecnicoMasIncidentesEspecialidadUltimosDias(especialidadBuscada, 5);
        System.out.println("Técnico con más incidentes resueltos en la especialidad " + especialidadBuscada.getNombreEspecialidad() + " en los últimos 5 días: " + tecnicoMasIncidentesEspecialidad.getNombre());

        // c. Quién fue el técnico que más rápido resolvió los incidentes
        Tecnico tecnicoMasRapido = rankingService.obtenerTecnicoMasRapido();
        System.out.println("Técnico que más rápido resolvió incidentes: " + tecnicoMasRapido.getNombre());

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
}
}