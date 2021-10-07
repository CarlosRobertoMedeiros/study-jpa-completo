package com.roberto.ecommerce.mapeamentoavancado;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HerancaTest extends EntityManagerTest {

    @Test
    public void salvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Fernando Marinho");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        entityManager.clear();
        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao.getId());
    }

    @Test
    public void buscarPagamentos() {
        List<Pagamento> pagamentos = entityManager
                .createQuery("select pc from PagamentoCartao pc")
                .getResultList();

        Assert.assertFalse(pagamentos.isEmpty());
    }

    @Test
    public void incluirPagamento(){
        Pedido pedido = entityManager.find(Pedido.class,1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setPedido(pedido);
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setNumeroCartao("123");

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getPagamentoCartao());

    }


}

