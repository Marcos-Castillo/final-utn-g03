package org.example.controller;

import org.example.DAO.IncidenteDAO;
import org.example.model.Incidente;

import javax.persistence.EntityManager;
import java.util.List;

public class IncidenteController {

    private IncidenteDAO incidenteDAO;

    public IncidenteController(EntityManager entityManager) {
        this.incidenteDAO = new IncidenteDAO(entityManager);
    }

    public void crearIncidente(Incidente incidente) {
        incidenteDAO.create(incidente);
    }

    public Incidente obtenerIncidente(Long id) {
        return incidenteDAO.findOne(id);
    }

    public List<Incidente> obtenerTodosLosIncidentes() {
        return incidenteDAO.findAll();
    }

    public void actualizarIncidente(Incidente incidente) {
        incidenteDAO.update(incidente);
    }

    public void eliminarIncidente(Long id) {
        Incidente incidente = incidenteDAO.findOne(id);
        if (incidente != null) {
            incidenteDAO.delete(incidente);
        }
    }
}
