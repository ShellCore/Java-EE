package testclientews;

import clientesga.ws.Persona;
import clientesga.ws.PersonaServiceImplService;
import clientesga.ws.PersonaServiceWS;
import java.util.List;

public class TestPersonaServiceWS {
    
    public static void main(String[] args) {
        PersonaServiceWS service = new PersonaServiceImplService().getPersonaServiceImplPort();
        System.out.println("Ejecutando el servicio Listar personas WS");
        List<Persona> list = service.listaPersonas();
        list.forEach(p -> {
            System.out.println("Persona {" + p.getNombre() + " " + p.getPaterno() + "}");
        });
        System.out.println("Fin del servicio Listar personas WS");
    }
}
