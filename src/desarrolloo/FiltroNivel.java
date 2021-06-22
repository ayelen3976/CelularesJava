/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrolloo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import bdd.Conex;
/**
 *
 * @author Fabian
 */
public class FiltroNivel {
    private final String sqlSelect1Nivel = "select idcliente, usuario, nivel from cliente where nivel = ?;";
    private final String sqlSelect2Niveles = "select idcliente, usuario, nivel from cliente where nivel = ? or nivel = ?;";
    private final String sqlSelect3Niveles = "select idcliente, usuario, nivel from cliente where nivel in (?, ?, ?);";
    private final String sqlSelect4Niveles = "select idcliente, usuario, nivel from cliente where nivel in (?, ?, ?, ?);";
    
    
    private Connection conn;
    private PreparedStatement ps;
    
    public FiltroNivel() {
     Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }
    
    DefaultTableModel datosTabla;
    String [] titTabla = {"codigo", "usuario", "Nivel"};
    String [][] filas = {};
    public DefaultTableModel obtenerTitulos() {
        datosTabla = new DefaultTableModel(filas, titTabla);
        
        return datosTabla;
    }
    
    public DefaultTableModel obtenerNiveles2(boolean nivel0, boolean nivel1, boolean nivel2, boolean nivel3) {
        String sqlSelect1NivelBase = "select idcliente, usuario, nivel from cliente where nivel = ";
        boolean agregarOr = false;
        if (nivel0) {
            agregarOr = true;
            sqlSelect1NivelBase = sqlSelect1NivelBase + "0";
        }
        if (nivel1) {
            if (agregarOr) {
                sqlSelect1NivelBase = sqlSelect1NivelBase + " or nivel = 1";
            } else {
                agregarOr = true;
                sqlSelect1NivelBase = sqlSelect1NivelBase + "1";
            }
        }
        if (nivel2) {
            if (agregarOr) {
                sqlSelect1NivelBase = sqlSelect1NivelBase + " or nivel = 2";
            } else {
                agregarOr = true;
                sqlSelect1NivelBase = sqlSelect1NivelBase + "2";
            }
        }
        if (nivel3) {
            if (agregarOr) {
                sqlSelect1NivelBase = sqlSelect1NivelBase + " or nivel = 3";
            } else {
                sqlSelect1NivelBase = sqlSelect1NivelBase + "3";
            }
        }
        int id;
        String usuario;
        int nivel;
        try {
            ps = conn.prepareStatement(sqlSelect1NivelBase);
            ResultSet resultado = ps.executeQuery(); 
            while (resultado.next()) {
                id = resultado.getInt(1);
                usuario = resultado.getString(2);
                nivel = resultado.getInt(3);
                Object [] vecFila = {id, usuario, nivel};
                datosTabla.addRow(vecFila);
            }
            
        }catch(SQLException ex) {
            System.out.println("error " + ex.getLocalizedMessage());
        }
        return datosTabla;                
    }
    
    public DefaultTableModel obtenerNiveles(boolean nivel0, boolean nivel1, boolean nivel2, boolean nivel3) {
        int id;
        String usuario;
        int nivel;
        int cantidadParametros = 0;
        try {
            if (nivel0) {
                cantidadParametros = cantidadParametros + 1;
                //ps.setInt(cantidadParametros, 0);
            }
            if (nivel1) {
                cantidadParametros = cantidadParametros + 1;
                //ps.setInt(cantidadParametros, 1);
            }
            if (nivel2) {
                cantidadParametros = cantidadParametros + 1;
                //ps.setInt(cantidadParametros, 2);
            }
            if (nivel3) {
                cantidadParametros = cantidadParametros + 1;
                //ps.setInt(cantidadParametros, 3);
            }
            switch (cantidadParametros) {
                case 1:
                    ps = conn.prepareStatement(sqlSelect1Nivel);
                    break;
                case 2:
                    ps = conn.prepareStatement(sqlSelect2Niveles);
                    break;
                case 3:
                    ps = conn.prepareStatement(sqlSelect3Niveles);
                    break;
                case 4:
                    ps = conn.prepareStatement(sqlSelect4Niveles);
                    break;
            }
            cantidadParametros = 0;
            if (nivel0) {
                cantidadParametros = cantidadParametros + 1;
                ps.setInt(cantidadParametros, 0);
            }
            if (nivel1) {
                cantidadParametros = cantidadParametros + 1;
                ps.setInt(cantidadParametros, 1);
            }
            if (nivel2) {
                cantidadParametros = cantidadParametros + 1;
                ps.setInt(cantidadParametros, 2);
            }
            if (nivel3) {
                cantidadParametros = cantidadParametros + 1;
                ps.setInt(cantidadParametros, 3);
            }
            
            ResultSet resultado = ps.executeQuery(); 
            while (resultado.next()) {
                
                id = resultado.getInt(1);
                usuario = resultado.getString(2);
                nivel = resultado.getInt(3);
                Object [] vecFila = {id, usuario, nivel};
                datosTabla.addRow(vecFila);
                
            }
            
        }catch(SQLException ex) {
            System.out.println("error " + ex.getLocalizedMessage());
        }
        return datosTabla;                
    }
    
}
