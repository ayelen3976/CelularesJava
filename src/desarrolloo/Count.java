package desarrolloo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import bdd.Conex;
import java.sql.Connection;

public class Count {

    private String usuario;
private String compania;
    PreparedStatement Ps;
    Connection conn;
    ResultSet Registro;

    public Count(String usuario, String compania) {
        this.usuario = usuario;
        this.compania = compania;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

  

    public Count() {
        Conex conexion = new Conex();
        conn = conexion.obtenerConexion();

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    DefaultTableModel objtabla;
    String[] TitCol = {"Tipo", "Cantidad"};
    String[][] Filas = {};

    public DefaultTableModel TitulosCount() {
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel DataCount(String CountU) {
        String SQLsaldo = "select saldo, COUNT(*) from cliente where saldo <=0 group by saldo;";     
        String SQLinactivos = "select activo, COUNT(*) from cliente where activo <=0 group by activo;";
        String SQLcompanyTel = "select compania, COUNT(*) from cliente group by compania;";
        String SQLnivel = "select nivel, COUNT(*) from cliente group by nivel;";
        String SQLsexo = "select sexo, COUNT(*) from cliente group by sexo;";
        String SQLmarca = "select marca, COUNT(*) from cliente group by marca;";

        try {
            if (CountU == "sin saldo") {
                Ps = conn.prepareStatement(SQLsaldo);
            } else if (CountU == "inactivos") {
                Ps = conn.prepareStatement(SQLinactivos);
            } else if (CountU == "compania telefonica") {
                Ps = conn.prepareStatement(SQLcompanyTel);
            } else if (CountU == "nivel") {
                Ps = conn.prepareStatement(SQLnivel);
            } else if (CountU == "sexo") {
                Ps = conn.prepareStatement(SQLsexo);
            } else if (CountU == "marca telefonica") {
                Ps = conn.prepareStatement(SQLmarca);
            }

            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {

                this.setUsuario(Registro.getString(1));
                this.setCompania(Registro.getString(2));
                Object[] vecFilas = {this.getUsuario(), this.getCompania()};
                objtabla.addRow(vecFilas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        return objtabla;
    }


}
