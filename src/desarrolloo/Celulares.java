package desarrolloo;

import bdd.ConexionOne;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import bdd.Conex;
import java.sql.Connection;

public class Celulares {

    private String user;
    private String nombre;
    private String sexo; 
    private int nivel;
    private String email;
    private String telefono;
    private String marca;
    private String compania;
    private double saldo;
    private boolean activo;
    private int id;
    private String sqlAlta = "INSERT INTO `cliente`(usuario, nombre, sexo, nivel, email, telefono, marca, compania, saldo, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    PreparedStatement Ps;
//    ConexionOne test = new ConexionOne();
    Connection conn;
    ResultSet Registro;

    public Celulares(String user, String nombre, String sexo, int nivel, String email, String telefono, String marca, String compania, double saldo, boolean activo) {
        this.user = user;
        this.nombre = nombre;
        this.sexo = sexo;
        this.nivel = nivel;
        this.email = email;
        this.telefono = telefono;
        this.marca = marca;
        this.compania = compania;
        this.saldo = saldo;
        this.activo = activo;

        obtenerConexion();
    }

    public Celulares() {
        Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }

    private void obtenerConexion() {
        Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getNivel() {
        return nivel;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMarca() {
        return marca;
    }

    public String getCompania() {
        return compania;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void Alta() {
        try {
            Ps = conn.prepareStatement(sqlAlta);

            Ps.setString(1, this.getUser());
            Ps.setString(2, this.getNombre());
            Ps.setString(3, this.getSexo());
            Ps.setInt(4, this.getNivel());
            Ps.setString(5, this.getEmail());
            Ps.setString(6, this.getTelefono());
            Ps.setString(7, this.getMarca());
            Ps.setString(8, this.getCompania());
            Ps.setDouble(9, this.getSaldo());
            Ps.setBoolean(10, this.activo);

            int registro = Ps.executeUpdate() ; //rayo de db que envia accion

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO GRABAR");
            }
        } catch (SQLException e) {
            System.out.println("funciona todo mal " + e);
            JOptionPane.showMessageDialog(null, "ERROR EN LA BASE DE DATOS ");
        }

    }

    public void Modificar(int CodigoId) {
        String sqlModificarbyId = "update cliente set usuario = '" + this.getUser() + "', nombre = '" + this.getNombre() + "', telefono = '" + this.getTelefono() + "' where idcliente = '" + CodigoId + "';";
        try {
            Ps = conn.prepareStatement(sqlModificarbyId);
            int registro = Ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Registro Modificado :p");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO EDITAAR");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERROR EN DELETE");

        }

    }


    DefaultTableModel objtabla;
    String[] TitCol = {"id", "Usuario", "Nombre"};
    String[][] Filas = {};

    public DefaultTableModel Titulos() {
        objtabla = new DefaultTableModel(Filas, TitCol);
        return objtabla;
    }

    public DefaultTableModel Data() {
        String SQLMostrar = "select idcliente, usuario, nombre from cliente;";
        try {
            Ps = conn.prepareStatement(SQLMostrar);
            Registro = Ps.executeQuery(); //devuelve un objeto perteneciente a una clase
            while (Registro.next() == true) {
                this.setId(Registro.getInt(1));
                this.setUser(Registro.getString(2));
                this.setNombre(Registro.getString(3));
                Object[] vecFilas = {this.getId(), this.getUser(), this.getNombre()};
                objtabla.addRow(vecFilas); 
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        return objtabla;
    }

    public boolean BuscarId(int CodigoId) {
        boolean existe;
        String sqlMostrarId = "select usuario, nombre, telefono , saldo from cliente where idcliente = '" + CodigoId + "'; ";

        try {
            Ps = conn.prepareStatement(sqlMostrarId);
            Registro = Ps.executeQuery();
            if (Registro.next()) {

                this.setUser(Registro.getString(1));
                this.setNombre(Registro.getString(2));
                this.setTelefono(Registro.getString(3));
                this.setSaldo(Registro.getDouble(4));
                existe = true;

            } else {
                existe = false;

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERROR EN BUSCAR ID");
            System.out.println("equis " + e);
            existe = false;
        }
        return existe;

    }
     
    public void Bajas(int CodigoId) {

        String sqlBorrarId = "delete from cliente where idcliente = '" + CodigoId + "'; ";

        try {
            Ps = conn.prepareStatement(sqlBorrarId);
            int registro = Ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado :p");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO BORRAAAARR");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERROR EN DELETE");

        }
    }

}

