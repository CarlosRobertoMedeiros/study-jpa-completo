package com.roberto.eventos.dao.interfaces;

import com.roberto.eventos.model.Evento;

import java.util.List;

public interface EventoDao {

    boolean salvar(Evento evento);
    void atualizar(Evento evento);
    Evento buscar(Integer id) ;
    List<Evento> listar();
    void deletar(Integer id);
}
