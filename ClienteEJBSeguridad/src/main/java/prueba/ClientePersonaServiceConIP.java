package prueba;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaServiceConIP {
    
    public static void main(String[] args) {
        System.out.println("Iniciando llamada remota al EJB desde el cliente\n");
        
        String authfile = "login.conf";
        System.setProperty("java.security.auth.login.config", authfile);
        ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
        programmaticLogin.login("admin", "admin".toCharArray());
        
        try {
            Properties prop = new Properties();
            prop.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            prop.setProperty("java.naming.factory.state", "com.sun.cobra.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            
            // Opcional Default localhost. Aqui se cambia la IP del servidor donde está GlassFish
            prop.setProperty("org.omg.COBRA.ORBInitialHost", "127.0.0.1");
            
            // Opcional. Puerto por default 3700. Solo se necesita cambiar si el puerto no es 3700
            // prop.setProperty("org.omg.COBRA.ORBInitialPort", "3700");
            
            Context jndi = new InitialContext(prop);
            PersonaServiceRemote service = (PersonaServiceRemote) jndi.lookup("java:global/SgaJeeWeb4/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> list = service.listaPersonas();
            list.forEach(p -> {
                System.out.println(p);
            });
            
            System.out.println("\nFin llamada remote al EJB desde el cliente");
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
