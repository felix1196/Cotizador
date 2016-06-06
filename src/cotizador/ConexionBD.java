package cotizador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private String nombreBD = "cotizador";
    private String nombreUser = "root";
    private String pass = "felix1196";
    private String url = "jdbc:mysql://localhost/" + nombreBD;
    Connection conn = null;

    public ConexionBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, nombreUser, pass);
            System.out.println("Conexion exitosa");            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al conectar" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar " + ex.getMessage());
        }

    }
public Connection getConexionBD(){
    
   return conn; 
}
}
