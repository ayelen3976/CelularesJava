
package desarrolloo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import bdd.Conex;

public class ListarTodo {
    private final String sqlSelectMarca = "SELECT DISTINCT marca from cliente ";
    private final String sqlSelectCompania = "SELECT DISTINCT compania from cliente ";
    private final String sqlSelectNombre = "SELECT nombre from cliente ";
 
    private Connection conn;
    private PreparedStatement ps;
    
    public ListarTodo() {
          Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }
    
    DefaultTableModel datosTabla;
    
    
    public DefaultTableModel obtenerTituloMarca() {
        String [] titTabla = {"Marca"};
        String [][] filas = {};
        datosTabla = new DefaultTableModel(filas, titTabla);
        
        return datosTabla;
    }
    
    public DefaultTableModel obtenerMarcas(boolean asc, boolean des, boolean dandom) {
        String marca;
        String sql;
        try {
            
            if (asc) {
                sql = sqlSelectMarca + "order by marca ASC;";
            } else {
                if (des) {
                    sql = sqlSelectMarca + "order by marca DESC;";
                } else {
                    sql = sqlSelectMarca + "order by RAND()";
                }
            }
            ps = conn.prepareStatement(sql);
            
            
            ResultSet resultado = ps.executeQuery(); 
            while (resultado.next()) {
                
                marca = resultado.getString(1);
                Object [] vecFila = {marca};
                datosTabla.addRow(vecFila);
                
            }
            
        }catch(SQLException ex) {
            System.out.println("error " + ex.getLocalizedMessage());
        }
        return datosTabla;                
    }
    
    public DefaultTableModel obtenerTituloCompania() {
        String [] titTabla = {"Compania"};
        String [][] filas = {};
        datosTabla = new DefaultTableModel(filas, titTabla);
        
        return datosTabla;
    }
    
    public DefaultTableModel obtenerCompanias(boolean asc, boolean des, boolean dandom) {
        String marca;
        String sql;
        try {
            
            if (asc) {
                sql = sqlSelectCompania + "order by compania ASC;";
            } else {
                if (des) {
                    sql = sqlSelectCompania + "order by compania DESC;";
                } else {
                    sql = sqlSelectCompania + "order by RAND()";
                }
            }
            ps = conn.prepareStatement(sql);
            
            
            ResultSet resultado = ps.executeQuery(); 
            while (resultado.next()) {
                
                marca = resultado.getString(1);
                Object [] vecFila = {marca};
                datosTabla.addRow(vecFila);
                
            }
            
        }catch(SQLException ex) {
            System.out.println("error " + ex.getLocalizedMessage());
        }
        return datosTabla;                
    }
    
    public DefaultTableModel obtenerTituloNombre() {
        String [] titTabla = {"Nombre"};
        String [][] filas = {};
        datosTabla = new DefaultTableModel(filas, titTabla);
        
        return datosTabla;
    }
    
    public DefaultTableModel obtenerNombres(boolean asc, boolean des, boolean dandom) {
        String marca;
        String sql;
        try {
            
            if (asc) {
                sql = sqlSelectNombre + "order by compania ASC;";
            } else {
                if (des) {
                    sql = sqlSelectNombre + "order by compania DESC;";
                } else {
                    sql = sqlSelectNombre + "order by RAND()";
                }
            }
            ps = conn.prepareStatement(sql);
            
            
            ResultSet resultado = ps.executeQuery(); 
            while (resultado.next()) {
                
                marca = resultado.getString(1);
                Object [] vecFila = {marca};
                datosTabla.addRow(vecFila);
                
            }
            
        }catch(SQLException ex) {
            System.out.println("error " + ex.getLocalizedMessage());
        }
        return datosTabla;                
    }
}
