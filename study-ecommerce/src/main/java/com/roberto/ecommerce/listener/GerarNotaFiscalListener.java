package com.roberto.ecommerce.listener;

import com.roberto.ecommerce.model.Pedido;
import com.roberto.ecommerce.service.NotaFiscalService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GerarNotaFiscalListener {

    private NotaFiscalService notaFiscalService = new NotaFiscalService();

    @PrePersist
    @PreUpdate
    public void gerar(Pedido pedido){

        if (pedido.isPago() && pedido.getNotaFiscal()==null){
            notaFiscalService.gerar(pedido);
        }

    }

}
