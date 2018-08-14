package mx.com.gm.sga.servicio;

import java.util.List;
import mx.com.gm.sga.domain.Persona;

public interface PersonaServiceRemote {
    
    List<Persona> listaPersonas();
    Persona encontrarPersonaPorId(Persona persona);
    Persona encontrarPersonaPorEmail(Persona persona);
    void registrarPersona(Persona persona);
    void modificarPersona(Persona persona);
    void eliminarPersona(Persona persona);
}
