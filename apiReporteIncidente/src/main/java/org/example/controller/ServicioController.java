package org.example.controller;

import org.example.DAO.ServicioDAO;
import org.example.model.Cliente;
import org.example.model.Servicio;

import javax.persistence.EntityManager;
import java.util.List;

public class ServicioController {

    private ServicioDAO servicioDAO;

    public ServicioController(EntityManager entityManager) {
        this.servicioDAO = new ServicioDAO(entityManager);
    }

    public void crearServicio(Servicio servicio) {
        servicioDAO.create(servicio);
    }

    public Servicio obtenerServicio(Long id) {
        return servicioDAO.findOne(id);
    }

    public List<Servicio> obtenerTodosLosServicios() {
        return servicioDAO.findAll();
    }

    public void actualizarServicio(Servicio servicio) {
        servicioDAO.update(servicio);
    }

    public void eliminarServicio(Long id) {
        Servicio servicio = servicioDAO.findOne(id);
        if (servicio != null) {
            servicioDAO.delete(servicio);
        }
    }
    public void contratarServicio(Cliente cliente, Servicio servicio) {
        cliente.contratarServicio(servicio);
    }

}
