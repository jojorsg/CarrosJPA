package br.com.josue.carros.dao;

import br.com.josue.carros.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarroDAO implements ICarroDAO {

    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("CarrosJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}
