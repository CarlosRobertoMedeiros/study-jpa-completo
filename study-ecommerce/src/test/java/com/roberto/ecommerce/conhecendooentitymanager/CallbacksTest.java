package com.roberto.ecommerce.conhecendooentitymanager;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Cliente;
import com.roberto.ecommerce.model.Pedido;
import com.roberto.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CallbacksTest extends EntityManagerTest {

    @Test
    public void acionarCallBacks() {
        Cliente cliente = entityManager.find(Cliente.class,1);

        Pedido pedido = new Pedido();
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(BigDecimal.TEN);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.flush();

        pedido.setStatus(StatusPedido.PAGO);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getDataCriacao());
        Assert.assertNotNull(pedidoVerificacao.getDataUltimaAtualizacao());
    }

}
