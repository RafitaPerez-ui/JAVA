import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Tarea;

public class ServicesLegend {
    
    private final String tabla = "legend";
    
    public void guardar(Connection conexion, LegendEntity tarea) throws SQLException{
        try{
            PreparedStatement consulta;
            if(tarea.getIdlegend() == null){
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(sentido, color) VALUES(?, ?)");
                consulta.setString(1, tarea.getSentido());
                consulta.setString(2, tarea.getColor());
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET sentido = ?, color = ? WHERE idlegend = ?");
                consulta.setString(1, tarea.getSentido());
                consulta.setString(2, tarea.getColor());
                consulta.setInt(3, tarea.getIdlegend());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Tarea recuperarPorId(Connection conexion, int idlegend) throws SQLException {
        Tarea tarea = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT sentido, color FROM " + this.tabla + " WHERE idlegend = ?" );
            consulta.setInt(1, idlegend);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tarea = new Tarea(idlegend, resultado.getString("sentido"), resultado.getString("color"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tarea;
    }
    
    public void eliminar(Connection conexion, LegendEntity tarea) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idlegend = ?");
            consulta.setInt(1, tarea.getIdlegend());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<Tarea> recuperarTodas(Connection conexion) throws SQLException{
        List<Tarea> legend = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT idlegend, sentido, color FROM " + this.tabla + " ORDER BY idlegend");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                legend.add(new Tarea(resultado.getInt("idlegend"), resultado.getString("sentido"), resultado.getString("color")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return legend;
    }
    
}
