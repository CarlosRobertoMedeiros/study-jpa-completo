package com.roberto.ecommerce.iniciandocomjpa;

import com.roberto.ecommerce.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
* Método tem apenas as propriedades e os métodos de callback
*
* */
public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");

    }

    @AfterClass
    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }

    @Before
    public void setUp() {
        System.out.println("SetUp");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        entityManager.close();
    }
}
