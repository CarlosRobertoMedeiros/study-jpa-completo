package com.roberto.eventos.dao;

import com.roberto.eventos.dao.interfaces.EventoDao;
import com.roberto.eventos.model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDaoImpl implements EventoDao {

    private static final String COMANDO_INSERIR_EVENTOS = " INSERT INTO TB_EVENTOS(NOME, DATA_CRIACAO) VALUES (?, ?) ";

    private static final String COMANDO_ATUALIZA_EVENTO_POR_ID = "UPDATE TB_EVENTOS "
            + " SET NOME = ?, DATA_CRIACAO = ?  WHERE ID_EVENTO =? ";

    private static final String COMANDO_LISTAR_EVENTOS_POR_ID = "SELECT ID_EVENTO, NOME, DATA_CRIACAO "
            + " FROM TB_EVENTOS WHERE ID_EVENTO =? ";

    private static final String COMANDO_LISTAR_EVENTOS = "SELECT ID_EVENTO, NOME, DATA_CRIACAO FROM TB_EVENTOS ";

    private static final String COMANDO_DELETA_EVENTO_POR_ID = "DELETE FROM TB_EVENTOS WHERE ID_EVENTO =?";

    @Override
    public boolean salvar(Evento evento) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(COMANDO_INSERIR_EVENTOS)) {
            int i = 0;
            pstmt.setString(++i, evento.getNome());
            pstmt.setDate(++i, new Date(System.currentTimeMillis()));
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(Evento evento) {
        try (PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(COMANDO_ATUALIZA_EVENTO_POR_ID)) {
            preparedStatement.setString(1, evento.getNome());
            preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
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

                return new Evento(id, resultSet.getString("NOME"),
                        resultSet.getDate("DATA_CRIACAO"));
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