package bdd;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionOne {

    String bdd = "jdbc:mysql://127.0.0.1:3306/ejemplo1" + "?user=" + "root" + "&password=" + "12345678" + "&useSSL=false";
    //atributos
//    private final String bdd = "jdbc:mysql://127.0.0.1:3306/ejemplo";//localhost://namedb
//    private final String user = "root";//root
//    private final String clave = "12345678";//

//    final String Driver = "com.mysql.jdbc.Driver";
    //constructor
    Connection con;

    public Connection conexion() {
        try {
            con = null;
//            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(bdd);
            if (!con.isClosed()) {
                System.out.println("Conectado!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("funciona todo mal " + e);
        }
        return con;
    }

    public String getBdd() {
        return bdd;
    }
    
    public Connection Conectado(){
        return con;
    }

}
