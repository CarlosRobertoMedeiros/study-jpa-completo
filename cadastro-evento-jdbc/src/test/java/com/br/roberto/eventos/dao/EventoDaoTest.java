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


// TODO:Elabora Melhor os testes
// Até o presente momento não estou usando a Connexão da classe de Teste
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
    public void deveCriarEvento(){
        Evento evento = new Evento(null,"Arrumar Notebook", new Date());
        EventoDao eventoDao = new EventoDaoImpl();
        eventoDao.salvar(evento);
    }

    @Test
    public void deveAtualizaEventoLavarLoucaParaTreinarNaAcademia(){
        //Pegar o ID 1
        EventoDao eventoDao = new EventoDaoImpl();
        Evento evento =  eventoDao.buscar(1);
        evento.setNome("Treinar na Academia");
        evento.setData(new java.sql.Date(evento.getData().getTime()));
        eventoDao.atualizar(evento);
    }

    @Test
    public void deveExcluirEventoArrumarACasa(){
        //Pegar o ID 2
        EventoDao eventoDao = new EventoDaoImpl();
        Evento evento =  eventoDao.buscar(2);
        eventoDao.deletar(evento.getId());
    }


}
