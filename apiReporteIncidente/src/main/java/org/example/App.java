package org.example;

import org.example.DAO.AbstractJpaDAO;
import org.example.DAO.ClienteDAO;
import org.example.config.DBConfig;
import org.example.model.Cliente;

import javax.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setRazonSocial("Empresa ABC");
        cliente.setCuit("123456789");
        cliente.setContactoPrincipal("John Doe");
        cliente.setTelefono("123-456-789");
        cliente.setEmail("john.doe@example.com");

        EntityManager entityManager = DBConfig.getEntityManager();


        AbstractJpaDAO<Cliente> clienteDAO = new ClienteDAO(entityManager);


        clienteDAO.create(cliente);



        System.out.println("Cliente guardado exitosamente en la base de datos.");
    }
}
