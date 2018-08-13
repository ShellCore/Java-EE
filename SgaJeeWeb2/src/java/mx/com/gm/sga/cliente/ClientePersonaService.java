package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando la llamada al EJB desde el cliente.\n");
            Context jndi = new InitialContext();
            PersonaServiceRemote remote = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = remote.listaPersonas();
            
            personas.forEach(p -> {
                System.out.println(p);
            });
            System.out.println("\nFin de la llamada al EJB desde el cliente");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
