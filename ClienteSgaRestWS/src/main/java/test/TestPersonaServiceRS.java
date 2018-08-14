package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestPersonaServiceRS {
    
    private static final String URL_BASE = "http://localhost:8080/SgaJeeWeb3/webservice";
    
    private static Client client;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        client = ClientBuilder.newClient();
        
        // Leer una persona (metodo GET)
        webTarget = client.target(URL_BASE)
                .path("/personas");
        
        // Proporcionamos un id válido
        persona = webTarget.path("/1")
                .request(MediaType.APPLICATION_XML)
                .get(Persona.class);
        System.out.println("Persona recuperada: " + persona);
        
        // Leer todas las personas (método GET con readEntity de tipo List<>)
        personas = webTarget.request(MediaType.APPLICATION_XML)
                .get(Response.class)
                .readEntity(new GenericType<List<Persona>>(){});
        System.out.println("Personas recuperadas:");
        imprimirPersonas(personas);
        
        // Agregar una persona (método POST)
        Persona p = new Persona();
        p.setNombre("Carlos");
        p.setPaterno("Miranda");
        p.setEmail("cmiranda@mail.com");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(p, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println(response.getStatus());
        
        // Recuperamos a la persona recien agregada para después modificarla y al final eliminarla
        Persona pRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada:" + p);
        
        // Modificar a la persona (método PUT)
        Persona pModificada = pRecuperada;
        pModificada.setMaterno("Gonzalez");
        String pathId = "/" + pModificada.getId();
        
        invocationBuilder = webTarget.path(pathId)
                .request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(pModificada, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println(response.getStatus());
        System.out.println("Persona modificada: " + response.readEntity(Persona.class));
        
        // Eliminar persona (método DELETE)
        Persona pEliminar = pRecuperada;
        String pathEliminarId = "/" + pEliminar.getId();
        invocationBuilder = webTarget.path(pathEliminarId)
                .request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        
        System.out.println("");
        System.out.println(response.getStatus());
        System.out.println("Persona Eliminada: " + pEliminar);
    }
    
    private static void imprimirPersonas(List<Persona> list) {
        list.forEach(p -> {
            System.out.println(p);
        });
    }
}
