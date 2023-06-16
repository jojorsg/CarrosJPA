package br.com.josue.carros.dao;

import br.com.josue.carros.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO {

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("CarrosJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }
}
