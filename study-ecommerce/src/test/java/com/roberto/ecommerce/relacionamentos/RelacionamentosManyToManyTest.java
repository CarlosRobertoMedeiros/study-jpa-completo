package com.roberto.ecommerce.relacionamentos;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class RelacionamentosManyToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {

        Produto produto = entityManager.find(Produto.class,1);
        Categoria categoria = entityManager.find(Categoria.class, 1);

        entityManager.getTransaction().begin();

        //categoria.setProdutos(Arrays.asList(produto)); //Por não ser o Owner do relacionamento não vai funcionar .. O mandatório são os produtos e não a categoria
        produto.setCategorias(Arrays.asList(categoria));
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class,categoria.getId());
        Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());


    }
}
