package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Persona;

@Remote
public interface PersonaServiceRemote {
    
    List<Persona> listaPersonas();
    Persona encontrarPersonaPorId(Persona persona);
    Persona encontrarPersonaPorEmail(Persona persona);
    void registrarPersona(Persona persona);
    void modificarPersona(Persona persona);
    void eliminarPersona(Persona persona);
    
}
