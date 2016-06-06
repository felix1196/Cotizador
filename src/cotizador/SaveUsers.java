package cotizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaveUsers {

    ConexionBD conexionOBJ = new ConexionBD();
    private Connection conn;

    public SaveUsers() {
        conn = conexionOBJ.getConexionBD();

    }

    public int Guardar(Usuario nombre) throws SQLException {

        String query = "INSERT INTO usuario VALUES(?,?,?)";
        int manejador = 0;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, nombre.getIdUsuario());
            ps.setString(2, nombre.getNombre());
            ps.setString(3, nombre.getContraseña());
            manejador = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());

                }
            }
        }

        return manejador;

    }

    public int editar(Usuario usuario) throws Exception {
        String query = "UPDATE usuario SET"
                + "Nombre = ?,"
                + "Contrasena = ?"
                + "WHERE Usuario = ?";

        int row = 0;

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContraseña());
            ps.setInt(3, usuario.getIdUsuario());

            row = ps.executeUpdate();

        } catch (Exception e) {
            throw new Exception(e);

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return row;
    }

    public int delete(Usuario usuario) throws Exception {

        String query = "DELETE FROM usuario WHERE matricula = ?";
        int row = 0;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario.getNombre());

            row = ps.executeUpdate();

        } catch (Exception e) {
            throw new Exception(e);

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return row;

    }

    public ArrayList<Usuario> obtener() {
        ArrayList<Usuario> arreglo = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try{
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContraseña(rs.getString("contraseña"));
                arreglo.add(usuario);
            }
            rs.close();
            st.close();
            
        }catch(Exception ex){
            System.out.println("error arraylsit "+ex.getMessage());
        }
        return arreglo;
    }
}
