package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Usuario;

@Remote
public interface UsuarioServiceRemote {
    
    List<Usuario> listaUsuarios();
    Usuario encontrarUsuarioPorId(Usuario usuario);
    Usuario encontrarUsuarioPorEmail(Usuario usuario);
    void registrarUsuario(Usuario usuario);
    void modificarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
}
