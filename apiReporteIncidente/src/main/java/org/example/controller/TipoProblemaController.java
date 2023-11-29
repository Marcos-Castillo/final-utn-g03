package org.example.controller;

import org.example.DAO.TipoProblemaDAO;
import org.example.model.TipoProblema;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoProblemaController {

    private TipoProblemaDAO tipoProblemaDAO;

    public TipoProblemaController(EntityManager entityManager) {
        this.tipoProblemaDAO = new TipoProblemaDAO(entityManager);
    }

    public void crearTipoProblema(TipoProblema tipoProblema) {
        tipoProblemaDAO.create(tipoProblema);
        System.out.println("Tipo de Problema creado con éxito: " + tipoProblema.getNombreTipoProblema());
    }

    public TipoProblema obtenerTipoProblema(Long id) {
        return tipoProblemaDAO.findOne(id);
    }

    public List<TipoProblema> obtenerTodosTiposProblema() {
        return tipoProblemaDAO.findAll();
    }

    public void actualizarTipoProblema(TipoProblema tipoProblema) {
        tipoProblemaDAO.update(tipoProblema);
        System.out.println("Tipo de Problema actualizado con éxito: " + tipoProblema.getNombreTipoProblema());
    }

    public void eliminarTipoProblema(Long id) {
        TipoProblema tipoProblema = tipoProblemaDAO.findOne(id);
        if (tipoProblema != null) {
            tipoProblemaDAO.delete(tipoProblema);
            System.out.println("Tipo de Problema eliminado con éxito: " + tipoProblema.getNombreTipoProblema());
        } else {
            System.out.println("No se encontró un Tipo de Problema con el ID proporcionado.");
        }
    }
}
