package org.example.DAO;
import org.example.config.DBConfig;
import org.example.model.Cliente;

import javax.persistence.EntityManager;

public class ClienteDAO extends AbstractJpaDAO<Cliente> {

    public ClienteDAO(EntityManager entityManager) {
        super(Cliente.class, entityManager);
    }



}
