package org.example.controller;

import org.example.DAO.EspecialidadDAO;
import org.example.model.Especialidad;

import javax.persistence.EntityManager;
import java.util.List;

public class EspecialidadController {

    private EspecialidadDAO especialidadDAO;

    public EspecialidadController(EntityManager entityManager) {
        this.especialidadDAO = new EspecialidadDAO(entityManager);
    }

    public void crearEspecialidad(Especialidad especialidad) {
        especialidadDAO.create(especialidad);
        System.out.println("Especialidad creada con éxito: " + especialidad.getNombreEspecialidad());
    }

    public Especialidad obtenerEspecialidad(Long id) {
        return especialidadDAO.findOne(id);
    }

    public List<Especialidad> obtenerTodasEspecialidades() {
        return especialidadDAO.findAll();
    }

    public void actualizarEspecialidad(Especialidad especialidad) {
        especialidadDAO.update(especialidad);
        System.out.println("Especialidad actualizada con éxito: " + especialidad.getNombreEspecialidad());
    }

    public void eliminarEspecialidad(Long id) {
        Especialidad especialidad = especialidadDAO.findOne(id);
        if (especialidad != null) {
            especialidadDAO.delete(especialidad);
            System.out.println("Especialidad eliminada con éxito: " + especialidad.getNombreEspecialidad());
        } else {
            System.out.println("No se encontró una especialidad con el ID proporcionado.");
        }
    }
}
