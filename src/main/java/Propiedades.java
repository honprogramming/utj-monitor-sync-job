
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar
 */
public class Propiedades {
    
    Properties propiedades = new Properties();
       
    File externo = new File(Main.urlArgumentos);
    
    public Properties getProperties() {
        
        try {
        
            if (externo.exists()&& externo.canRead()) {                
                
                try(FileInputStream raiz = new FileInputStream(externo)) {
                    
                    propiedades.load(raiz);
                    
                } 
            
            } else {
                
                try (InputStream raiz = getClass().getResourceAsStream("ArchivoConfig.properties")) {
         
                propiedades.load(raiz);
        
                }
         
            }
        
            if (!propiedades.isEmpty()) {                
            
                return propiedades;
            
            } else {//sino  retornara NULL
        
                return null;
            
            }
        
        } catch (IOException ex) {
                
            return null;
        
        }
        
    }
    
}
