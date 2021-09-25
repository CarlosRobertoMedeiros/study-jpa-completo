package com.roberto.ecommerce.iniciandocomjpa;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador() {
        Produto produto = entityManager.find(Produto.class, 1);
        //Produto produto = entityManager.getReference(Produto.class, 1); //só vai no banco quando usar uma propriedade dentro de produto funciona na linha 16

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarAReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone Samson");

        entityManager.refresh(produto);//Atualizei para voltar a ser Kindle
        Assert.assertEquals("Kindle", produto.getNome());

    }

}
