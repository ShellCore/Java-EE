package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Usuario;

@Local
public interface UsuarioService {
    
    List<Usuario> listaUsuarios();
    Usuario encontrarUsuarioPorId(Usuario usuario);
    Usuario encontrarUsuarioPorEmail(Usuario usuario);
    void registrarUsuario(Usuario usuario);
    void modificarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
}
