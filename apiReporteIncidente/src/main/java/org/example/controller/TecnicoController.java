package org.example.controller;

import org.example.DAO.IncidenteDAO;
import org.example.DAO.ServicioDAO;
import org.example.DAO.TecnicoDAO;
import org.example.model.Incidente;
import org.example.model.Tecnico;

import javax.persistence.EntityManager;
import java.util.List;

public class TecnicoController {

     private TecnicoDAO tecnicoDAO;
    private IncidenteDAO incidenteDAO;


    public TecnicoController(EntityManager entityManager) {

        this.tecnicoDAO = new TecnicoDAO(entityManager);
        this.incidenteDAO = new IncidenteDAO(entityManager);

    }
    public void crearTecnico(Tecnico tecnico) {
        tecnicoDAO.create(tecnico);
        System.out.println("Técnico creado con éxito: " + tecnico.getNombre());
    }

    public Tecnico obtenerTecnico(Long id) {
        return tecnicoDAO.findOne(id);
    }

    public List<Tecnico> obtenerTodosTecnicos() {
        return tecnicoDAO.findAll();
    }

    public void actualizarTecnico(Tecnico tecnico) {
        tecnicoDAO.update(tecnico);
        System.out.println("Técnico actualizado con éxito: " + tecnico.getNombre());
    }

    public void eliminarTecnico(Long id) {
        Tecnico tecnico = tecnicoDAO.findOne(id);
        if (tecnico != null) {
            tecnicoDAO.delete(tecnico);
            System.out.println("Técnico eliminado con éxito: " + tecnico.getNombre());
        } else {
            System.out.println("No se encontró un técnico con el ID proporcionado.");
        }
    }

    public void asignarIncidente(Tecnico tecnico, Incidente incidente) {
        // Verifica que el técnico esté disponible
        if (!tecnico.isDisponible()) {
            System.out.println("El técnico no está disponible. No se puede asignar el incidente.");
            return;
        }

        // Asigna el incidente al técnico
        try {
            tecnico.asignarIncidente(incidente);
            tecnicoDAO.update(tecnico); // Actualiza el técnico en la base de datos
            System.out.println("Incidente asignado al técnico: " + tecnico.getNombre());
        } catch (IllegalStateException e) {
            System.out.println("No se pudo asignar el incidente. " + e.getMessage());
        }
    }

    public void resolverIncidente(Tecnico tecnico, Incidente incidente) {
        // Verifica que el técnico tenga el incidente asignado
        if (!tecnico.getIncidentesAsignados().contains(incidente)) {
            System.out.println("El técnico no tiene asignado el incidente. No se puede resolver.");
            return;
        }

        // Realiza la lógica de resolución del incidente
        try {
            tecnico.resolverIncidente(incidente);
            tecnicoDAO.update(tecnico);
            incidenteDAO.update(incidente);
            System.out.println("Incidente resuelto por el técnico: " + tecnico.getNombre());
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo resolver el incidente. " + e.getMessage());
        }
    }



}
