
package conexionbdd_ejemplo;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author JavaDev
 */
public class ConexionBDD_Ejemplo {
    Connection con = null;
    private String user,
                            pass,
                            url;
    
    public Connection conexion(){
        url = "jdbc:mysql://localhost/bdd_ejemplo";
        user = "root";
        pass = "";
        try {
            //Cargar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            JOptionPane.showMessageDialog(null, "Conexion establecida");
        } 
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion error:" + e.getMessage());
        }
        return con;
    }
    
    public void cerrar(){
        try {
            con.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La Conexcion a la base de datos no se pudo cerrar correctamente");
        }
    }
  
}
