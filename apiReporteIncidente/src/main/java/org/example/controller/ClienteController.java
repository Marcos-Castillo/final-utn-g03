package org.example.controller;

import org.example.DAO.ClienteDAO;
import org.example.model.Cliente;
import org.example.model.Servicio;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteController {

    private ClienteDAO clienteDAO;
    private ServicioController servicioController;

    public ClienteController(EntityManager entityManager, ServicioController servicioController) {
        this.clienteDAO = new ClienteDAO(entityManager);
        this.servicioController = servicioController;
    }

    public void crearCliente(Cliente cliente) {
        clienteDAO.create(cliente);
    }

    public Cliente obtenerCliente(Long id) {
        return clienteDAO.findOne(id);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.findAll();
    }

    public void actualizarCliente(Cliente cliente) {
        clienteDAO.update(cliente);
    }

    public void eliminarCliente(Long id) {
        Cliente cliente = clienteDAO.findOne(id);
        if (cliente != null) {
            clienteDAO.delete(cliente);
        }
    }


    public void contratarServicio(Cliente cliente, Servicio servicio) {
        if (cliente != null && servicio != null) {
            servicioController.contratarServicio(cliente, servicio);
            clienteDAO.update(cliente);
        }
    }
}
