package com.roberto.eventos.dao;

import com.roberto.eventos.dao.interfaces.EventoDao;
import com.roberto.eventos.model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDaoImpl implements EventoDao {

    private static final String COMANDO_INSERIR_EVENTOS = " INSERT INTO TB_EVENTOS(ID, NOME, DATA) "
            + " VALUES (APP.EVENTOS_SEQ.nextval , ?, ?)";

    private static final String COMANDO_ATUALIZA_EVENTO_POR_ID = "UPDATE TB_EVENTOS "
            + " SET NOME = ?, DATA = ?  WHERE ID =? ";

    private static final String COMANDO_LISTAR_EVENTOS_POR_ID = "SELECT ID, NOME, DATA "
            + " FROM TB_TODOS WHERE ID =? ";

    private static final String COMANDO_LISTAR_EVENTOS = "SELECT ID, NOME, DATA FROM TB_EVENTOS ";

    private static final String COMANDO_DELETA_EVENTO_POR_ID = "DELETE FROM TB_TODOS WHERE ID =?";


    @Override
    public boolean salvar(Evento evento) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(COMANDO_INSERIR_EVENTOS)) {
            int i = 0;
            pstmt.setString(++i, evento.getNome());
            pstmt.setDate(++i, new Date(evento.getData().getTime()));
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(Evento evento) {
        try (PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(COMANDO_ATUALIZA_EVENTO_POR_ID)) {
            preparedStatement.setString(1, evento.getNome());
            preparedStatement.setDate(2, new Date(evento.getData().getTime()));
            preparedStatement.setInt(3, evento.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Evento buscar(Integer id) {

        try (PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(COMANDO_LISTAR_EVENTOS_POR_ID)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                return new Evento(id, resultSet.getString("nome"),
                        resultSet.getDate("data"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Evento> listar() {

        try (PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(COMANDO_LISTAR_EVENTOS)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Evento> eventos = new ArrayList<Evento>();

                while (resultSet.next()) {
                    eventos.add(new Evento(resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getDate("data")));
                }
                return eventos;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(Integer id) {

        try (PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(COMANDO_DELETA_EVENTO_POR_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

//TODO: Atualizar o JUNit com os testes de crud e aplicá-los
// https://github.com/CarlosRobertoMedeiros/study-JavaEE/blob/master/crudjavaeejdbc/src/crudjavaeejdbc/dao/TodoDAOImpl.java