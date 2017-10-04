import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
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
public class Cliente {
    
    private String output = null;
    
    public String clienteGet (String url, Logger log) {
    
        try {

            Client cliente = Client.create();

            WebResource webResource = cliente.resource(url);

	    ClientResponse respuesta = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

            if (respuesta.getStatus() != 200) {
				
                log.error("Error : HTTP código de estatus : " + respuesta.getStatus());
			
            }

            output = respuesta.getEntity(String.class);

	} catch (Exception e) {

            log.error("Error: ", e);

	}
        
	return output;
    
    }
    
}
