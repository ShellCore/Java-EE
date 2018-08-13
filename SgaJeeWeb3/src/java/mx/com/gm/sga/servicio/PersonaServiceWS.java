package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Persona;

@WebService
public interface PersonaServiceWS {
    
    @WebMethod
    public List<Persona> listaPersonas();
    
    @WebMethod
    public Persona encontrarPersonaPorId(Persona persona);
    
    @WebMethod
    void registrarPersona(Persona persona);
    
    @WebMethod
    void modificarPersona(Persona persona);
    
    @WebMethod
    void eliminarPersona(Persona persona);
}
