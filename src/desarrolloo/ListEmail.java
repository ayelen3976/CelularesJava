package desarrolloo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import bdd.Conex;
import java.sql.Connection;

public class ListEmail {

    private String email;

    PreparedStatement Ps;
    Connection conn;
    ResultSet Registro;

    public ListEmail(String email) {
        this.email = email;

    }

    public ListEmail() {
        Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    DefaultTableModel objtabla;
    String[] TitCol = {"Email"};
    String[][] Filas = {};

    public DefaultTableModel TitulosEmail() {
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel DataEmail(String Correo) {
        String SQLgmail = "select email from cliente where email like '%gmail%'";
        String SQLyahoo = "select  email from cliente where email NOT like '%yahoo'";
        String SQLhotmail = "select email from cliente where email like '%hotmail%';";

        try {
            if (Correo == "only Gmail") {
                Ps = conn.prepareStatement(SQLgmail);
            } else if (Correo == "los que no usan Yahoo") {

                Ps = conn.prepareStatement(SQLyahoo);
            } else {
                Ps = conn.prepareStatement(SQLhotmail);
            }

            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {
                this.setEmail(Registro.getString(1));

                Object[] vecFilas = {this.getEmail()};
                objtabla.addRow(vecFilas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        return objtabla;
    }
}
