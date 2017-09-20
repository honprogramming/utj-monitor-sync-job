
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    
    private Properties propiedades = new Properties();
       
    public Propiedades(String urlArgumentos) throws FileNotFoundException, IOException {
      
        File externo = new File(urlArgumentos);

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
        } catch (IOException ex) {
                
            System.out.println("Envíar a log");
        
        }
        
    }
    
    public Properties getProperties() {
        
        return propiedades;
    
    }
    
}
