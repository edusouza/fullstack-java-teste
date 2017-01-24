package br.com.contabilizei.desafio.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by contabilizei on 20/01/2017.
 */
public class ConnectionManager {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:contabilizei.db");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

}
