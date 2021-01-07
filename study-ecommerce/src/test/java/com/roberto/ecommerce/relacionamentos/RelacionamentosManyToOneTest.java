package com.roberto.ecommerce.relacionamentos;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentosManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class,1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        ItemPedido itemPedido2 = new ItemPedido();
        itemPedido2.setPrecoProduto(produto.getPreco());
        itemPedido2.setQuantidade(10);
        itemPedido2.setPedido(pedido);
        itemPedido2.setProduto(produto);

        entityManager.getTransaction().begin();

        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.persist(itemPedido2);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class, itemPedido2.getId());
        Assert.assertNotNull(itemPedidoVerificacao.getPedido());
        Assert.assertNotNull(itemPedidoVerificacao.getProduto());
    }
}
