
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
        private static Job job01;
        private static Job job02; 
        private static Job job03; 
        private static Job job04;
      
        private static int numIndicadores;
        
        public static String urlArgumentos;
        
        private static Properties propiedades;
        
        private static Correo correo;
        
        private static ScheduledExecutorService ejecutar;
        
    public static void main(String[] args) throws IOException {
        
        if ( args.length != 0 ) {
          
           urlArgumentos = args[0];
          
        } else {
            
            urlArgumentos = "ArchivoConfig.properties";
            
        }
        
        propiedades = new Propiedades(urlArgumentos).getProperties();
        
        correo = new Correo(propiedades);
        
        int hora = Integer.parseInt(propiedades.getProperty("horaInicio"));
        int minuto = Integer.parseInt(propiedades.getProperty("minutoInicio"));
        numIndicadores = Integer.parseInt(propiedades.getProperty("numIndicadores"));
        
        job01 = new Job(numIndicadores-numIndicadores, numIndicadores/4, correo);
        job02 = new Job(numIndicadores/4, (numIndicadores/4)*2, correo);
        job03 = new Job((numIndicadores/4)*2, (numIndicadores/4)*3, correo);
        job04 = new Job((numIndicadores/4)*3, numIndicadores, correo);
                
        LocalDateTime localNow = LocalDateTime.now();
        ZoneId currentZone = ZoneId.of("America/Mexico_City");
        ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
        ZonedDateTime zonedNext5 ;
        zonedNext5 = zonedNow.withHour(hora).withMinute(minuto).withSecond(0);
        if(zonedNow.compareTo(zonedNext5) > 0)
            zonedNext5 = zonedNext5.plusDays(1);

        Duration duration = Duration.between(zonedNow, zonedNext5);
        long initalDelay = duration.getSeconds();

        ejecutar = Executors.newScheduledThreadPool(4);            
        ejecutar.scheduleAtFixedRate(job01, initalDelay, 1, TimeUnit.SECONDS);
        //ejecutar.scheduleAtFixedRate(job02, initalDelay, 1, TimeUnit.SECONDS);
        //ejecutar.scheduleAtFixedRate(job03, initalDelay, 1, TimeUnit.SECONDS);
        //ejecutar.scheduleAtFixedRate(job04, initalDelay, 1, TimeUnit.SECONDS);
        
    }
  
}
