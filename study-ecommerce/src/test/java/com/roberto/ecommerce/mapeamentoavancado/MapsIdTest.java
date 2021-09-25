package com.roberto.ecommerce.mapeamentoavancado;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Cliente;
import com.roberto.ecommerce.model.ItemPedido;
import com.roberto.ecommerce.model.ItemPedidoId;
import com.roberto.ecommerce.model.NotaFiscal;
import com.roberto.ecommerce.model.Pedido;
import com.roberto.ecommerce.model.Produto;
import com.roberto.ecommerce.model.StatusPedido;

public class MapsIdTest extends EntityManagerTest {

	@Test
	public void inserirPagamento() {

		Pedido pedido = entityManager.find(Pedido.class, 1);

		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setPedido(pedido);
		notaFiscal.setDataEmissao(new Date());
		notaFiscal.setXml("<xml/>");

		entityManager.getTransaction().begin();
		entityManager.persist(notaFiscal);
		entityManager.getTransaction().commit();

		entityManager.clear();

		NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());
		Assert.assertNotNull(notaFiscalVerificacao);
		Assert.assertEquals(pedido.getId(), notaFiscalVerificacao.getId());

	}

	@Test
	public void inserirItemPedido() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataConclusao(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(produto.getPreco());

		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setId(new ItemPedidoId());
		itemPedido.setPedido(pedido);
		itemPedido.setProduto(produto);
		itemPedido.setPrecoProduto(produto.getPreco());
		itemPedido.setQuantidade(1);

		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.persist(itemPedido);
		entityManager.getTransaction().commit();

		entityManager.clear();

		ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class,
				new ItemPedidoId(pedido.getId(), produto.getId()));
		Assert.assertNotNull(itemPedidoVerificacao);

	}

}
