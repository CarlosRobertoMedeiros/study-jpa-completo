package com.roberto.ecommerce.listener;

import java.io.Serializable;

import javax.persistence.PostLoad;

public class GenericoListener {

    @PostLoad
    public void logCarregamento(Object object){
        System.out.println("Entidade " +object.getClass().getSimpleName()+ " foi carregada.");
    }

}
