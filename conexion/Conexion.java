import java.sql.*;
public class Conexion {

    private static Connection ObjConexion = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (ObjConexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ObjConexion = DriverManager.getConnection("jdbc:mysql://localhost/java_mysql", "root", "");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return ObjConexion;
    }

    public static void cerrar() throws SQLException {
        if (ObjConexion != null) {
            ObjConexion.close();
        }
    }

}
