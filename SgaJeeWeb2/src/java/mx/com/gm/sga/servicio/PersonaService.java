package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Persona;

@Local
public interface PersonaService {
    
    List<Persona> listaPersonas();
    Persona encontrarPersonaPorId(Persona persona);
    Persona encontrarPersonaPorEmail(Persona persona);
    void registrarPersona(Persona persona);
    void modificarPersona(Persona persona);
    void eliminarPersona(Persona persona);
}
