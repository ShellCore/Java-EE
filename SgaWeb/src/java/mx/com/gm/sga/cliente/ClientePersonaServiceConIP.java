package mx.com.gm.sga.cliente;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaServiceConIP {
    
    public static void main(String[] args) {
        try {
            System.out.println("--- Iniciando la llamada al EJB desde el cliente ---\n");
            Properties prop = new Properties();
            prop.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            prop.setProperty("java.naming.factory.state", "com.sun.cobra.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            // Optional. Default Localhost. Aquí se cambia la IP del servidor donde se encuentra Glassfish
            prop.setProperty("org.omg.COBRA.ORBInitialHost", "127.0.0.1");
            // Optional. Puero por Default  3700. Solo se necesita cambiar si el puerto no es 3700
            // prop.setProperty("org.omg.COBRA.ORBInitialPort", "3700");

            Context jndi = new InitialContext(prop);
            PersonaServiceRemote remote = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = remote.listaPersonas();
            personas.forEach(p -> {
                System.out.println(p);
            });
            
            System.out.println("\n--- Fin de la llamada al EJB desde el cliente---");
            
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
