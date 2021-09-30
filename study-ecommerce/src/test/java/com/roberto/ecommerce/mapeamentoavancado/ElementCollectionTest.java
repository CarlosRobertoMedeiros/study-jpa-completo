package com.roberto.ecommerce.mapeamentoavancado;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class ElementCollectionTest extends EntityManagerTest{
	 
	@Test
	public void aplicarTags() {
		entityManager.getTransaction().begin();
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setTags(Arrays.asList("ebook","livro-digital"));
		entityManager.getTransaction().commit();

		entityManager.clear();
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertFalse(produtoVerificacao.getTags().isEmpty());
	}

	@Test
	public void aplicarAtributos() {
		entityManager.getTransaction().begin();
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setAtributos(Arrays.asList(new Atributo("tela","320x600"),new Atributo("cor","verde")));
		entityManager.getTransaction().commit();

		entityManager.clear();
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertFalse(produtoVerificacao.getAtributos().isEmpty());
	}

	@Test
	public void aplicarContato() {
		entityManager.getTransaction().begin();
		Cliente cliente = entityManager.find(Cliente.class, 1);
		cliente.setContatos(Collections.singletonMap("email","fernando@email.com"));
		entityManager.getTransaction().commit();

		entityManager.clear();
		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertEquals("fernando@email.com", clienteVerificacao.getContatos().get("email"));
	}
}
