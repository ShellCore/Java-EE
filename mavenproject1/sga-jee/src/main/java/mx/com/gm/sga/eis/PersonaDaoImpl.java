package mx.com.gm.sga.eis;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao {
    
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll")
                .getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        // TODO Falta implementación findPersonaByEmail(Persona persona)
        return null;
    }

    @Override
    public void insertPersona(Persona persona) {
        // TODO Falta implementación insertPersona(Persona persona)
    }

    @Override
    public void updatePersona(Persona persona) {
        // TODO Falta implementación updatePersona(Persona persona)
    }

    @Override
    public void deletePersona(Persona persona) {
        // TODO Falta implementación deletePersona(Persona persona)
    }
    
}
