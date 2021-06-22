package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MakeTable {

    ConexionOne ConnDB = new ConexionOne();

    private static final String createTableClient = "CREATE TABLE cliente "
            + "(ID INT PRIMARY KEY,"
            + " USUARIO TEXT, "
            + " NOMBRE VARCHAR(20),"
            + " SEXO TEXT,"
            + " NIVEL INT,"
            + " EMAIL VARCHAR(30),"
            + " TELEFONO INT,"
            + " MARCA TEXT,"
            + " COMPANIA TEXT,"
            + " SALDO FLOAT,"
            + " ACTIVO BOOLEAN)";

    public void createTableClient() {

        try (Connection connection = DriverManager.getConnection(ConnDB.getBdd());
                Statement statement = connection.createStatement();) {
            statement.execute(createTableClient);
            System.out.println("The client table has been successfully created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
