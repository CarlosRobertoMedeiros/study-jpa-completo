package com.br.roberto.eventos.dao;

import com.roberto.eventos.dao.EventoDaoImpl;
import com.roberto.eventos.dao.interfaces.EventoDao;
import com.roberto.eventos.model.Evento;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EventoDaoTest {

    private static Connection connection;

    @BeforeClass
    public static void iniciarClasse() throws SQLException{
        connection = ConnectionFactoryTest.getConnection();
        System.out.println("Chamando o inciarClasse");
    }

    @AfterClass
    public static void encerrarClasse() throws SQLException{
        connection.close();
        System.out.println("Chamando o encerrarClasse");
    }

    @Test
    public void criarEvento(){
        Evento evento = new Evento(null,"Arrumar Notebook", new Date());
        EventoDao eventoDao = new EventoDaoImpl();
        eventoDao.salvar(evento);
    }
    @Test
    public void atualizaEvento(Evento evento){
        EventoDao eventoDao = new EventoDaoImpl();
        eventoDao.atualizar(evento);
    }


}
