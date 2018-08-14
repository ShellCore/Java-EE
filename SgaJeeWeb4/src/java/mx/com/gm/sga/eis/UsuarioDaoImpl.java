package mx.com.gm.sga.eis;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
    
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll")
                .getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getId());
    }

    @Override
    public Usuario findUsuarioByEmail(Usuario usuario) {
        // TODO Falta implementación findUsuarioByEmail(Usuario usuario)
        return null;
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        // TODO Falta implementación insertUsuario(Usuario usuario)
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        // TODO Falta implementación updateUsuario(Usuario usuario)
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        // TODO Falta implementación
    }
    
}
