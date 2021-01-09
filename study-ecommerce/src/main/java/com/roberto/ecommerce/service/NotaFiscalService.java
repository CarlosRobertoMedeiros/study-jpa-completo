package com.roberto.ecommerce.service;

import com.roberto.ecommerce.model.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido){
        System.out.println("Gerando Nota Para o Pedido "+pedido.getId()+" .");

    }
}
