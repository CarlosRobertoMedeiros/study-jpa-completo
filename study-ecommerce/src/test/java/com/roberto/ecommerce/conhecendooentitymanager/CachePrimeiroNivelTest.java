package com.roberto.ecommerce.conhecendooentitymanager;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Produto;
import org.junit.Test;

public class CachePrimeiroNivelTest extends EntityManagerTest {

    @Test
    public void verificarCache(){

        try {
            Produto produto = entityManager.find(Produto.class,1);
            System.out.println(produto.getNome());

            System.out.println("-------------------------------------");

            Produto produtoResgatado = entityManager.find(Produto.class,produto.getId());
            System.out.println(produtoResgatado.getNome());
        }catch (Exception e){
            throw new RuntimeException("Erro: "+e.getMessage());
        }

    }
}
