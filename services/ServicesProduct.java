import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Tarea;

public class ServicesProduct{
    
    private final String tabla = "products";
    
    public void guardar(Connection conexion, LegendEntity tarea) throws SQLException{
        try{
            PreparedStatement consulta;
            if(tarea.getidproducts() == null){
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombreproducts, total, idwarehouse, restante) VALUES(?, ?, ?, ?)");
                consulta.setString(1, tarea.getSentido());
                consulta.setString(2, tarea.getColor());
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombreproducts = ?, total = ?, idwarehouse = ?, restante = ? WHERE idproducts = ?");
                consulta.setString(1, tarea.getSentido());
                consulta.setString(2, tarea.getColor());
                consulta.setInt(3, tarea.getidproducts());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Tarea recuperarPorId(Connection conexion, int idproducts) throws SQLException {
        Tarea tarea = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT nombreproducts, total, idwarehouse, restante FROM " + this.tabla + " WHERE idproducts = ?" );
            consulta.setInt(1, idproducts);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tarea = new Tarea(idproducts, resultado.getString("nombreproducts"), resultado.getString("total"), resultado.getString("idwarehouse"), resultado.getString("restante"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tarea;
    }
    
    public void eliminar(Connection conexion, LegendEntity tarea) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idproducts = ?");
            consulta.setInt(1, tarea.getidproducts());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<Tarea> recuperarTodas(Connection conexion) throws SQLException{
        List<Tarea> legend = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT nombreproducts, total, idwarehouse, restante FROM " + this.tabla + " ORDER BY idproducts");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                legend.add(new Tarea(resultado.getInt("idproducts"), resultado.getString("nombreproducts"), resultado.getString("total"), resultado.getString("idwarehouse"), resultado.getString("restante")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return legend;
    }
    
}
