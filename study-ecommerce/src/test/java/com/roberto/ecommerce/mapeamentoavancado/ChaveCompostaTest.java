package com.roberto.ecommerce.mapeamentoavancado;

import java.time.LocalDateTime;

import org.junit.Test;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Cliente;
import com.roberto.ecommerce.model.ItemPedido;
import com.roberto.ecommerce.model.ItemPedidoId;
import com.roberto.ecommerce.model.Pedido;
import com.roberto.ecommerce.model.Produto;
import com.roberto.ecommerce.model.StatusPedido;

import junit.framework.Assert;

public class ChaveCompostaTest extends EntityManagerTest{
	 
	@Test
	public void salvarItem() {
		entityManager.getTransaction().begin();
		
		Cliente cliente = entityManager.find(Cliente.class,1);
		Produto produto = entityManager.find(Produto.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(produto.getPreco());
		

		ItemPedido itemPedido = new ItemPedido();
//		itemPedido.setPedidoId(pedido.getId());    //Aqui era usando o IdClass
//		itemPedido.setProdutoId(produto.getId());  //Aqui era usando o IdClass
		itemPedido.setId(new ItemPedidoId());
		itemPedido.setPedido(pedido);
		itemPedido.setProduto(produto);
		itemPedido.setPrecoProduto(produto.getPreco());
		itemPedido.setQuantidade(1);

		entityManager.persist(pedido);
		entityManager.persist(itemPedido);
		entityManager.getTransaction().commit();

		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao);
		Assert.assertFalse(pedidoVerificacao.getItemPedidos().isEmpty());
				
	}
	
	@Test
	public void buscarItem() {
		ItemPedido itemPedido = entityManager.find(ItemPedido.class, new ItemPedidoId(1,1));
		Assert.assertNotNull(itemPedido);
		
	}

}
