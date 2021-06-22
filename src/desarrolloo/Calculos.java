package desarrolloo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import bdd.Conex;
import java.sql.Connection;

public class Calculos {

    private String marca;
    private String compania;
    private String sexo;
    private String x;
    PreparedStatement Ps;
    Connection conn;
    ResultSet Registro;

    public Calculos(String marca, String compania, String sexo, String x) {
        this.marca = marca;
        this.compania = compania;
        this.sexo = sexo;
        this.x = x;
    }

    public Calculos() {
        Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCompania() {
        return compania;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    DefaultTableModel objtabla;

    String[][] Filas = {};

    public DefaultTableModel TitulosCalculosPromedio() {
        String[] TitCol = {"Promedio", "Marca",};
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel DataCalculosPromedio(String MarcaOrComp) {
        String SQLnokia = "select avg(saldo), marca from cliente where marca = 'NOKIA';";
        String SQLlg = "select avg(saldo), marca from cliente where marca = 'LG';";

        try {
            if (MarcaOrComp == "NOKIA") {
                Ps = conn.prepareStatement(SQLnokia);
            } else if (MarcaOrComp == "LG") {

                Ps = conn.prepareStatement(SQLlg);
            }

            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {

                this.setMarca(Registro.getString(1));
                this.setX(Registro.getString(2));
                Object[] vecFilas = {this.getMarca(), this.getX()};
                objtabla.addRow(vecFilas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        return objtabla;
    }

    public DefaultTableModel TitulosCalculosSuma() {
        String[] TitCol = {"Suma", "Compania"};
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel DataCalculosSuma(String MarcaOrComp) {
        String SQLnextel = "select sum(saldo), compania from cliente where compania = 'NEXTEL';";
        String SQLunifon = "select sum(saldo), compania from cliente where compania = 'UNEFON';";
        String SQLtelcel = "select sum(saldo) as suma_saldos, compania from cliente where compania = 'TELCEL';";

        try {
            if (MarcaOrComp == "NEXTEL") {

                Ps = conn.prepareStatement(SQLnextel);
            } else if (MarcaOrComp == "UNIFON") {

                Ps = conn.prepareStatement(SQLunifon);
            } else if (MarcaOrComp == "TELCEL") {

                Ps = conn.prepareStatement(SQLtelcel);
            }

            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {
                this.setMarca(Registro.getString(1));
                this.setX(Registro.getString(2));
                Object[] vecFilas = {this.getMarca(), this.getX()};
                objtabla.addRow(vecFilas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        return objtabla;
    }

    public DefaultTableModel TitulosSexoMax() {
        String[] TitCol = {"Saldo Maximo", "Sexo"};
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel DataSexoMax(String sexo) {
        String SQLmaxh = "select max(saldo), sexo from cliente where sexo='H';";
        String SQLmaxm = "select max(saldo), sexo from cliente where sexo='F';";

        try {
            if (sexo == "F") {

                Ps = conn.prepareStatement(SQLmaxm);
            } else if (sexo == "H") {

                Ps = conn.prepareStatement(SQLmaxh);
            }
            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {
                
                this.setSexo(Registro.getString(1));
                this.setX(Registro.getString(2));
                Object[] vecFilas = {this.getSexo(), this.getX()};
                objtabla.addRow(vecFilas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        return objtabla;
    }

    public DefaultTableModel TitulosSexoMin() {
        String[] TitCol = {"Saldo Minimo", "Sexo"};
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel DataSexoMin(String sexo) {
        String SQLminh = "select min(saldo), sexo from cliente where sexo='H';";
        String SQLminm = "select min(saldo), sexo from cliente where sexo='F';";

        try {
            if (sexo == "F") {

                Ps = conn.prepareStatement(SQLminm);
            } else if (sexo == "H") {

                Ps = conn.prepareStatement(SQLminh);
            }
            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {
                this.setSexo(Registro.getString(1));
                this.setX(Registro.getString(2));
                Object[] vecFilas = {  this.getSexo(), this.getX()};
                objtabla.addRow(vecFilas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        return objtabla;
    }

}
