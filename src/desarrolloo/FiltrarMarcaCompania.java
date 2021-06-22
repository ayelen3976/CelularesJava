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
public class FiltrarMarcaCompania {
    private Connection conn;
    private PreparedStatement ps;
    
    DefaultTableModel datosTabla;
    
    String [] titulo1 = new String[1];
    String [] titulo2 = new String[2];
    String [] titulo3 = new String[3];
    String [][] filas = {};
    
    private int cantidadColumnas;
    
    public FiltrarMarcaCompania() {
        Conex conexion = new Conex();
        conn = conexion.obtenerConexion();
    }
    
    private String generarColumnasSql(boolean usuarioSeleccionado, boolean nombreSeleccionado, boolean telefonoSeleccionado) {
        String columnas = "";
        boolean agregarComa = false;
        if (usuarioSeleccionado) {
            agregarComa = true;
            columnas = "usuario";
        }
        if (nombreSeleccionado) {
            if (agregarComa) {
                columnas = columnas + ", nombre";
            } else {
                agregarComa = true;
                columnas = columnas + "nombre";
            }
        }
        if (telefonoSeleccionado) {
            if (agregarComa) {
                columnas = columnas + ", telefono";
            } else {
                columnas = "telefono";
            }
        }
        return columnas;
    }
    
    private String campoString(String campo) {
        String campoString = "'" + campo + "'";
        return campoString;
    }
    
    
    
    private String generarColumnasInMarcas(boolean samsungSeleccionado, boolean lgSeleccionado, boolean nokiaSeleccionado, boolean motorolaSeleccionado, boolean blackberrySeleccionado) {
        String valores = "";
        
        boolean agregarComa = false;
        if (samsungSeleccionado) {
            agregarComa = true;
            valores = campoString("SAMSUNG");
        }
        if (lgSeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("LG");
            } else {
                agregarComa = true;
                valores = campoString("LG");
            }
        }
        if (nokiaSeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("NOKIA");
            } else {
                agregarComa = true;
                valores = campoString("NOKIA");
            }
        }
        if (motorolaSeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("MOTOROLA");
            } else {
                agregarComa = true;
                valores = campoString("MOTOROLA");
            }
        }
        if (blackberrySeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("BLACKBERRY");
            } else {
                agregarComa = true;
                valores = campoString("BLACKBERRY");
            }
        }
        return valores;
    }
    
    private String generarColumnasInCompanias(boolean atytSeleccionado, boolean axelSeleccionado, boolean telcelSeleccionado, boolean unifonSeleccionado, boolean iUsacellSeleccionado, boolean movistarSeleccinado) {
        String valores = "";
        
        boolean agregarComa = false;
        if (atytSeleccionado) {
            agregarComa = true;
            valores = campoString("AT&T");
        }
        if (axelSeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("AXEL");
            } else {
                agregarComa = true;
                valores = campoString("AXEL");
            }
        }
        if (telcelSeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("TELCEL");
            } else {
                agregarComa = true;
                valores = campoString("TELCEL");
            }
        }
        if (unifonSeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("UNEFON");
            } else {
                agregarComa = true;
                valores = campoString("UNEFON");
            }
        }
        if (iUsacellSeleccionado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("IUSACELL");
            } else {
                agregarComa = true;
                valores = campoString("IUSACELL");
            }
        }
        if (movistarSeleccinado) {
            if (agregarComa) {
                valores = valores + ", " + campoString("MOVISTAR");
            } else {
                valores = campoString("MOVISTAR");
            }
        }
        return valores;
    }
    
    public DefaultTableModel busquedaPersonalizada(boolean usuarioSeleccionado, boolean nombreSeleccionado, boolean telefonoSeleccionado, boolean marcaSeleccionada, boolean incluyeSeleccionado, boolean samsungSeleccionado, boolean lgSeleccionado, boolean nokiaSeleccionado, boolean motorolaSeleccionado, boolean blackberrySeleccionado, boolean atytSeleccionado, boolean axelSeleccionado, boolean telcelSeleccionado, boolean unifonSeleccionado, boolean iUsacellSeleccionado, boolean movistarSeleccinado) {
        String sql = "select " + generarColumnasSql(usuarioSeleccionado, nombreSeleccionado, telefonoSeleccionado) + " from cliente where ";
        String campoFiltro;
        if (marcaSeleccionada) {
            campoFiltro = "marca";
        } else {
            campoFiltro = "compania";
        }
        sql = sql + campoFiltro;
        
        String in;
        if (incluyeSeleccionado) {
            in = " in (";
        } else {
            in = " not in (";
        }
        sql = sql + in;
        
        if (marcaSeleccionada) {
            sql = sql + generarColumnasInMarcas(samsungSeleccionado, lgSeleccionado, nokiaSeleccionado, motorolaSeleccionado, blackberrySeleccionado);
        } else {
            sql = sql + generarColumnasInCompanias(atytSeleccionado, axelSeleccionado, telcelSeleccionado, unifonSeleccionado, iUsacellSeleccionado, movistarSeleccinado);
        }
        sql = sql + ");";
        try {
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery(); 
            while (resultado.next()) {
                String col1;
                String col2;
                String col3;
                switch(cantidadColumnas) {
                    case 1:
                        col1 = resultado.getString(1);
                        Object [] vecFila = {col1};
                        datosTabla.addRow(vecFila);
                        break;
                    case 2:
                        col1 = resultado.getString(1);
                        col2 = resultado.getString(2);
                        Object [] vecFila2 = {col1, col2};
                        datosTabla.addRow(vecFila2);
                        break;
                    case 3:
                        col1 = resultado.getString(1);
                        col2 = resultado.getString(2);
                        col3 = resultado.getString(3);
                        Object [] vecFila3 = {col1, col2, col3};
                        datosTabla.addRow(vecFila3);
                        break;    
                }

            }
            
        }catch(SQLException ex) {
            System.out.println("error " + ex.getLocalizedMessage());
        }
        return datosTabla; 
            
    }
    
    public DefaultTableModel obtenerTitulos(boolean usuarioSeleccionado, boolean nombreSeleccionado, boolean telefonoSeleccionado) {
        
        cantidadColumnas = 0;
        if (usuarioSeleccionado) {
            cantidadColumnas = cantidadColumnas + 1;
            titulo1[0] = "Usuario;";
            titulo2[0] = "Usuario;";
            titulo3[0] = "Usuario;";
        }
        if (nombreSeleccionado) {
            cantidadColumnas = cantidadColumnas + 1;
            if (cantidadColumnas == 1) {
                titulo1[0] = "Nombre;";
                titulo2[0] = "Nombre;";
            } else {
                titulo2[1] = "Nombre;";
                titulo3[1] = "Nombre;";
            }
            
            
        }
        
        if (telefonoSeleccionado) {
            cantidadColumnas = cantidadColumnas + 1;
            if (cantidadColumnas == 1) {
                titulo1[0] = "Telefono;";
            } else {
                if (cantidadColumnas == 2) {
                    titulo2[1] = "Telefono;";
                } else {
                    //titulo2[2] = "Telefono;";
                    titulo3[2] = "Telefono;";
                }
            }
        }
        
        switch(cantidadColumnas) {
            case 1:
                datosTabla = new DefaultTableModel(filas, titulo1);
                break;
            case 2:
                datosTabla = new DefaultTableModel(filas, titulo2);
                break;
            case 3:
                datosTabla = new DefaultTableModel(filas, titulo3);
                break;    
        }
        
        return datosTabla;
    }
    
}
