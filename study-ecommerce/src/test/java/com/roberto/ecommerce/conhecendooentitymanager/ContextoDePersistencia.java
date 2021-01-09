package com.roberto.ecommerce.conhecendooentitymanager;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;

public class ContextoDePersistencia extends EntityManagerTest {

    @Test
    public void usarContextoPersistencia(){
        //Por Limitações do Oracle Esse código vai ser comentado
        /*
        Produto produto = entityManager.find(Produto.class,1);

        entityManager.getTransaction().begin();

        produto.setPreco(new BigDecimal(100.0));


        Produto produto2 = new Produto();
        produto2.setNome("Caneca Para Café");
        produto2.setPreco(new BigDecimal(10.0));
        produto2.setDescricao("Boa Caneca para Café");
        entityManager.persist(produto2); //Aqui o Produto2 entra no ConextoDePersistencia

        Produto produto3 = new Produto();
        produto3.setNome("Caneca Para Chá");
        produto3.setPreco(new BigDecimal(10.0));
        produto3.setDescricao("Boa Caneca para Chá");
        produto3 = entityManager.merge(produto3); //Aqui o Produto3 entra no ConextoDePersistencia

        entityManager.flush();

        produto3.setDescricao("Alterar a Descrição");

        entityManager.getTransaction().commit();

         */
    }


}
