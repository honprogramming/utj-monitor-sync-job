
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar
 */

public class Conexion {
    
    private Connection conexion;
    private String url;
    private String usuario;
    private String clave;
    
    public Conexion(){

    this.url = "jdbc:sqlserver://localhost;databaseName=agrarian;user=sa;password=rociomarcc";  
    //this.url = "jdbc:sqlserver://localhost\\MSSQLSERVER1;databaseName=guadalajara1;integratedSecurity=true";
    this.usuario = "root";
    this.clave = "";
    
    }

    public Connection getConexion() {
        
        return conexion;
    
    }
    
    public Connection conexionSQL(Logger log){
        
        try {
        
            this.conexion = DriverManager.getConnection(url);
            
        } catch (SQLException ex) {

            log.error("Error al conectar a la Base de Datos", ex);
        
        }
        
        return conexion;
        
    }
        
    public void desconectarSQL () {
        
        try {
        
            conexion.close();
        
        }catch (SQLException ex) {
        
            System.out.println("Error al desconectar");
        
        }
    }    

}

