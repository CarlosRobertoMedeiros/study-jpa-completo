package com.roberto.ecommerce.util;

import com.roberto.ecommerce.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IniciarUnidadeDePersistencia {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Faz os Testes
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());

        //Encerra
        entityManager.close();
        entityManagerFactory.close();

    }
}
