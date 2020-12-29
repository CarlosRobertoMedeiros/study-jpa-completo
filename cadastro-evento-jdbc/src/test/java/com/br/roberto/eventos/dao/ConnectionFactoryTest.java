package com.br.roberto.eventos.dao;

import java.sql.*;

public class ConnectionFactoryTest {

    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER_NAME = "App";
    private static final String PASSWORD = "12345";


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Problemas na Conexão ", e);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problemas na Conexão ", e);
        }

    }

    public static void closeConnection(Connection con, PreparedStatement statement) {
        closeConnection(con);
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problemas na Conexão ", e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement statement, ResultSet resultset) {
        closeConnection(con, statement);
        try {
            if (resultset != null) {
                resultset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problemas na Conexão ", e);
        }
    }


}
