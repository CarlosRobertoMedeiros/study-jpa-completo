package com.roberto.ecommerce.mapeamentobasico;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Cliente;
import com.roberto.ecommerce.model.EnderecoEntregaPedido;
import com.roberto.ecommerce.model.Pedido;
import com.roberto.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

    @Test
    public void analisarMapeamentoEmbutido(){

        Cliente cliente = entityManager.find(Cliente.class, 1);

        EnderecoEntregaPedido enderecoEntrega = new EnderecoEntregaPedido();
        enderecoEntrega.setCep("70000-000");
        enderecoEntrega.setLogradouro("Rua das Laranjeiras");
        enderecoEntrega.setNumero("123");
        enderecoEntrega.setBairro("Centro");
        enderecoEntrega.setCidade("Uberlândia");
        enderecoEntrega.setEstado("MG");

        Pedido pedido = new Pedido();
        //pedido.setId(1);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));

        pedido.setEnderecoEntrega(enderecoEntrega);
        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());

    }
}
