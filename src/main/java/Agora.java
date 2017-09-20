
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar
 */
public class Agora {
    
    private String indicador;
    private Date fecha;
    private Conexion conexion;

    public Agora(Conexion conexion) {
        
        this.indicador = null;
        this.fecha = null;
        this.conexion = conexion;
        
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public Date consultarAgora(int codigo) {
        
        conexion.conexionSQL();
        
        PreparedStatement comando = null;
        
        try {
            
        
            comando = conexion.getConexion().prepareStatement("select nombre, fechaReg from cliente WHERE idCliente=?");
            
            comando.setInt(1,codigo);
            
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                
                this.setIndicador(rs.getString(1));
                this.setFecha(rs.getDate(2));
                
            }
            
        } catch (SQLException e) {}
        
        return fecha;
        
    }
    
}
