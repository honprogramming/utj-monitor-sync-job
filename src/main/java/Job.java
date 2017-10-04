
import java.io.IOException;
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
public class Job implements Runnable {
    
    private Logger log;
    
    private Correo correo;
    
    private Conexion conexion;
    
    private Agora agora;
    
    private Cliente cliente;
    
    private String mensaje;
    private String url;
    
    long inicio, fin, tiempo; //Variables para determinar el tiempo de ejecución
    
    int indicadorFinal;
    int indicadorActual;
    
    public Job (int indicadorInicial, int indicadorFinal, Correo correo, Logger log) throws IOException {
        
        this.indicadorActual = indicadorInicial;
        this.indicadorFinal = indicadorFinal;
        this.correo = correo;
        this.conexion = new Conexion();
        this.cliente = new Cliente();
        this.log = log;
        this.agora = new Agora(this.conexion, this.log);
    
    }
    
    @Override
    public void run() {
        
        url = "https://postman-echo.com/get?test=";
        
        inicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        
            indicadorActual++;
            
            System.out.println("Consultar por código del indicador en UTJ Monitor " + indicadorActual);
            System.out.println(cliente.clienteGet(url, log));
            log.info(indicadorActual + " Indicador consultado en UTJ Monitor");
            //Este IF es solo para probar si envía correo
            /*if ( indicadorActual == 1 ) {
            
                mensaje = "Inicio de Job";
            
                correo.sendMail(mensaje);
       
            }*/
            
            try {
                    
                Thread.sleep(500);
                
            } catch (InterruptedException ex) {
                   
                log.warn("Error");
               
            }

            System.out.println("Consultar por código del indicador en Agora " + agora.consultarAgora(indicadorActual));
            log.info(indicadorActual + " Indicador consultado en AGORA");
            
            try {
                    
                Thread.sleep(500);
                
            } catch (InterruptedException ex) {
                   
                log.warn("Error");
                
            }

            System.out.println("Comparar la fecha de Agora con la fecha UTJ Monitor ¿Fecha de último indicador de Agora es mayor a fecha de último indicador de UTJ Monitor?");

            try {
                    
                Thread.sleep(500);
                
            } catch (InterruptedException ex) {
                   
                log.warn("Error");
                
            }

            if ( indicadorFinal > indicadorActual ) {
                    
                System.out.println("Si: Insertar datos en UTJ Monitor");
                System.out.println();
                log.info(indicadorActual + " Indicador actualizado en UTJ Monitor");
                    
            } else {
                
                System.out.println("NO: Verifica siguiente indicador");
                System.out.println();
                
            }
            
             try {
                    
                Thread.sleep(500);
                
            } catch (InterruptedException ex) {
                   
                log.warn("Error");
                
            }
                
            if ( indicadorActual >= indicadorFinal ) {
                    
                System.out.println("Ya no hay mas indicadores");
                System.out.println();
                log.info(" Recorrido Completo");
                
                fin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = (fin - inicio) * indicadorFinal; //Calculamos los milisegundos de diferencia
                System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos  
             
            }  
        
    }
    
    
}
