package com.roberto.ecommerce.relacionamentos;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Categoria;
import com.roberto.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class RemovendoEntidadesReferenciadasTest extends EntityManagerTest {

    @Test
    public void removerEntidadeRelacionada() {
        Pedido pedido = entityManager.find(Pedido.class,1);

        Assert.assertFalse(pedido.getItemPedidos().isEmpty());

        entityManager.getTransaction().begin();
        pedido.getItemPedidos().forEach(item -> entityManager.remove(item)); //removo cada item sem usar CASCATA
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();;

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,1);
        Assert.assertNull(pedidoVerificacao);

    }


}
