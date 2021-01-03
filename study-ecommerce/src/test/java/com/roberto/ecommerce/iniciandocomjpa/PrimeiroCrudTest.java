package com.roberto.ecommerce.iniciandocomjpa;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirCliente() {
        Cliente cliente = new Cliente();

        cliente.setId(3);
        cliente.setNome("Carlos Roberto");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }


    @Test
    public void buscarPorIdentificador() {
        Cliente cliente = entityManager.find(Cliente.class, 2);
        Assert.assertNotNull(cliente);
        Assert.assertEquals("Marcos Mariano", cliente.getNome());
    }

    @Test
    public void atualizaCliente() {
        Cliente cliente = new Cliente();

        cliente.setId(1);
        cliente.setNome("Luciene Alves Medeiros de Lima");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 2);
        Assert.assertNotNull(cliente);
        Assert.assertEquals("Luciene Alves Medeiros de Lima", cliente.getNome());

    }

    @Test
    public void removeCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 1);
        Assert.assertNull(clienteVerificacao);
    }

}
