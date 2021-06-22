//ESTA ES LA CONEXION QUE USO PARA TODO EL PROYECTO :)
package bdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conex {
     private Connection conn;
    //private final String dataBase = "jdbc:mysql://127.0.0.1:3306/basedemo";
//    private final String dataBase = "jdbc:mysql://Localhost/ejemplo1";
//    
//    private final String usuario = "root";
//    private final String clave = "12345678";
//    
    private final String driver = "com.mysql.jdbc.Driver";
       String bdd = "jdbc:mysql://127.0.0.1:3306/ejemplo1" + "?user=" + "root" + "&password=" + "12345678" + "&useSSL=false";
    //jdbc:mysql://127.0.0.1:3306/basedemo

    public Conex() {
        conectarse();
    }
    
    
    
    private void conectarse() {
        try {
            Class.forName(driver);
//            String conexionCadena = "jdbc:mysql://"+  dataBase;
            conn = DriverManager.getConnection(bdd);
            
//            if (conn != null) {
//                System.out.println("Conectadoooo");
//            }
            
        } catch(Exception ex) {
            System.out.println("error: " + ex.getLocalizedMessage());
        }
        
        
    }

    public Connection obtenerConexion() {
        return conn;
    }
}
