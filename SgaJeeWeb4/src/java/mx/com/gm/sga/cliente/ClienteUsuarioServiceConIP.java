package mx.com.gm.sga.cliente;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioServiceRemote;

public class ClienteUsuarioServiceConIP {
    
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando la llamada al EJB desde el cliente\n");
            Properties prop = new Properties();
            prop.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            prop.setProperty("java.naming.factory.state", "com.sun.cobra.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            prop.setProperty("org.omg.COBRA.ORBInitialHost", "127.0.0.1");
            
            Context jndi = new InitialContext(prop);
            UsuarioServiceRemote remote = (UsuarioServiceRemote) jndi.lookup("java:global(sga/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioServiceRemote");
            
            List<Usuario> usuarios = remote.listaUsuarios();
            usuarios.forEach(u -> {
                System.out.println(u);
            });
            
            System.out.println("\nFin de la llamada al EJB desde el cliente");
            
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
