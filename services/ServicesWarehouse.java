import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Tarea;

public class ServicesWarehouse {
    
    private final String tabla = "warehouse";
    
    public void guardar(Connection conexion, LegendEntity tarea) throws SQLException{
        try{
            PreparedStatement consulta;
            if(tarea.getidwarehouse() == null){
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombrewarehouse, min, max) VALUES(?, ?, ?)");
                consulta.setString(1, tarea.getSentido());
                consulta.setString(2, tarea.getColor());
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombrewarehouse = ?, min = ?, max = ? WHERE idwarehouse = ?");
                consulta.setString(1, tarea.getSentido());
                consulta.setString(2, tarea.getColor());
                consulta.setInt(3, tarea.getidwarehouse());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Tarea recuperarPorId(Connection conexion, int idwarehouse) throws SQLException {
        Tarea tarea = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT nombrewarehouse, min, max FROM " + this.tabla + " WHERE idwarehouse = ?" );
            consulta.setInt(1, idwarehouse);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tarea = new Tarea(idwarehouse, resultado.getString("nombrewarehouse"), resultado.getString("min"), resultado.getString("max"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tarea;
    }
    
    public void eliminar(Connection conexion, LegendEntity tarea) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idwarehouse = ?");
            consulta.setInt(1, tarea.getidwarehouse());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<Tarea> recuperarTodas(Connection conexion) throws SQLException{
        List<Tarea> legend = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT idwarehouse, nombrewarehouse, min, max FROM " + this.tabla + " ORDER BY idwarehouse");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                legend.add(new Tarea(resultado.getInt("idwarehouse"), resultado.getString("nombrewarehouse"), resultado.getString("min"), resultado.getString("max")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return legend;
    }
    
}
