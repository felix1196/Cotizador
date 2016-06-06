package cotizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddComponentsBD {

    ConexionBD conexionOb = new ConexionBD();
    private Connection con; 
    
 
 public AddComponentsBD(){
     con = conexionOb.getConexionBD();
     
 }   
 
 public String Guardar(Componentes componente) throws SQLException{
 
     String query = "INSERT INTO componentes values(?,?,?,?)";
     int man = 0;
     PreparedStatement ps = null;
     
     try {
       
         ps = con.prepareStatement(query);
         ps.setString(1,componente.getCategoria());
         ps.setString(2,componente.getComponente());
         ps.setInt(3,componente.getIdComponentes());
         ps.setInt(4,componente.getExistentes());
         ps.setDouble(5,componente.getPrecio());
         
         man = ps.executeUpdate();
         
     }catch(SQLException ex){
         System.out.println("error"+ ex.getMessage());
     }finally{
         if(ps != null){
             try{
                 ps.close();
                 
             }catch(SQLException ex){
                 System.out.println("error" +ex.getMessage());
             }
         }
 
     }
        return null;
  
 }
}
