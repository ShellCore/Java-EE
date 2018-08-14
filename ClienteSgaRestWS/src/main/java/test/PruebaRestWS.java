package test;

import domain.Persona;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class PruebaRestWS {
    
    private static final String URL = "http://localhost:8080/SgaJeeWeb4/webservice";
    
    public static void main(String[] args) {
        
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive()
                .credentials("admin", "admin")
                .build();
        
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        Client client = ClientBuilder.newClient(clientConfig);
        
        WebTarget webTarget = client.target(URL)
                .path("/personas");
        
        // Proporcionamos un id válido
        Persona persona = webTarget.path("/1")
                .request(MediaType.APPLICATION_XML)
                .get(Persona.class);
        
        System.out.println("Persona recuperada: " + persona);
    }
}
