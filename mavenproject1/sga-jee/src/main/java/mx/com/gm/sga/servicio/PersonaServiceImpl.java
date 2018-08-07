package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote {

    @Override
    public List<Persona> listaPersonas() {
        List<Persona> list = new ArrayList<>();
        list.add(new Persona(1, "Juan", "Perez", "Suarez", "jperez@mail.com", "51234567"));
        list.add(new Persona(2, "Martha", "Suarez", "Jimenez", "msuarez@mail.com", "98765432"));
        return list;
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        // TODO Falta implementación encontrarPersonaPorId(Persona persona)
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        // TODO Falta implementación encontrarPersonaPorEmail(Persona persona)
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
        // TODO Falta implemtación registrarPersona(Persona persona)
    }

    @Override
    public void modificarPersona(Persona persona) {
        // TODO Falta implementación modificarPersona(Persona persona)
    }

    @Override
    public void eliminarPersona(Persona persona) {
        // TODO Falta implementación eliminarPersona(Persona persona)
    }
    
}
