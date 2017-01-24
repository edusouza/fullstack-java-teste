package br.com.contabilizei.desafio;

import br.com.contabilizei.desafio.db.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by contabikiller on 20/01/2017.
 */
public class DatabaseSeeds {

    public static void main(String[] args) {

        try ( Connection connection = ConnectionManager.getConnection() )
        {

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists empresa");
            statement.executeUpdate("drop table if exists notafiscal");
            statement.executeUpdate("drop table if exists imposto");

            statement.executeUpdate("create table person (id integer, razao_social string )");

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
