package com.roberto.ecommerce.relacionamentos;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class RelacionamentosOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {

        Pedido pedido = entityManager.find(Pedido.class,1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumeroCartao("1234");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getPagamentoCartao());
    }

    @Test
    public void verificarRelacionamentoPedidoNotaFiscal() {

        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        //notaFiscal.setXml("Teste");
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getNotaFiscal());
    }



}
