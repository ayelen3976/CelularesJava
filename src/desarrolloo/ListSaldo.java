package desarrolloo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import bdd.Conex;
import java.sql.Connection;

public class ListSaldo {

    private String Saldo;
    private String x;
    PreparedStatement Ps;
    Connection conn;
    ResultSet Registro;

    public void setRegistro(ResultSet Registro) {
        this.Registro = Registro;
    }

    public ListSaldo() {

        Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }

    public String getSaldo() {
        return Saldo;
    }

    public void setSaldo(String Saldo) {
        this.Saldo = Saldo;
    }

    public ResultSet getRegistro() {
        return Registro;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public ListSaldo(String Saldo, String x) {
        this.Saldo = Saldo;
        this.x = x;
    }

    DefaultTableModel objtabla;
    String[] TitCol = {"X", "Saldo"};
    String[][] Filas = {};

    public DefaultTableModel TitulosSaldos() {
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel DataSaldos(String option) {
        String SQLopt1 = "select telefono, saldo from cliente where saldo <=300;";
        String SQLopt2 = "select telefono , saldo from cliente where saldo <= 0;";
        String SQLopt3 = "select telefono, saldo from cliente where saldo >= 300;";
        String SQLopt4 = "select nombre, saldo, activo from cliente where saldo<=0";
        String SQLopt5 = "select nombre, saldo, activo from cliente where not activo;";
        String SQLopt6 = "select usuario, activo from cliente where NOT activo;";

        try {
            if (option == "option1") {
                Ps = conn.prepareStatement(SQLopt1);
            } else if (option == "option2") {

                Ps = conn.prepareStatement(SQLopt2);
            } else if (option == "option3") {

                Ps = conn.prepareStatement(SQLopt3);
            } else if (option == "option4") {

                Ps = conn.prepareStatement(SQLopt4);
            } else if (option == "option5") {

                Ps = conn.prepareStatement(SQLopt5);
            } else if (option == "option6") {

                Ps = conn.prepareStatement(SQLopt6);
            }

            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {
              
                this.setX(Registro.getString(1));
                  this.setSaldo(Registro.getString(2));
                Object[] vecFilas = {this.getX(), this.getSaldo()};
                objtabla.addRow(vecFilas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR en saldos");
        }

        return objtabla;
    }
}

