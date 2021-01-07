package com.roberto.ecommerce.relacionamentos;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Pedido;
import org.junit.Test;

public class OptionalTest extends EntityManagerTest {

    @Test
    public void verificarComportamento(){
        Pedido pedido = entityManager.find(Pedido.class,1);

    }
}
