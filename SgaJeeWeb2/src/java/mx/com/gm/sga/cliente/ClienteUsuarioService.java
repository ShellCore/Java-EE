package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioServiceRemote;

public class ClienteUsuarioService {
    
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando la llamada al EJB desde el cliente.\n");
            Context jndi = new InitialContext();
            UsuarioServiceRemote remote = (UsuarioServiceRemote) jndi.lookup("java:global/sga-jee/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioServiceRemote");
            
            List<Usuario> usuarios = remote.listaUsuarios();
            
            usuarios.forEach(u ->  {
                System.out.println(u);
            });
            
            System.out.println("\nFin de la llamada al EJB desde el cliente");
            
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
