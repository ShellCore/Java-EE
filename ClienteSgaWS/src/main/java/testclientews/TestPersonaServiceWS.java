package testclientews;

import clientesga.ws.Persona;
import clientesga.ws.PersonaServiceImplService;
import clientesga.ws.PersonaServiceWS;
import java.util.List;

public class TestPersonaServiceWS {

    static PersonaServiceWS service;
    static Persona persona1;
    
    public static void main(String[] args) {
        service = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        probarListarPersonas();
//        probarAgregarPersona();
        probarModificarPersona();
        probarEliminarPersona();
    }

    private static void probarListarPersonas() {
        System.out.println("\nEjecutando el servicio Listar personas WS");
        List<Persona> list = service.listaPersonas();
        list.forEach(p -> {
            System.out.println("Persona {" + p.getNombre() + " " + p.getPaterno() + "}");
        });
        System.out.println("Fin del servicio Listar personas WS");
    }
    
    private static void probarAgregarPersona() {
        System.out.println("\nEjecutando el servicio Registrar persona WS");
        persona1 = new Persona();
        persona1.setNombre("Prueba");
        persona1.setPaterno("Prueba");
        persona1.setEmail("Prueba@mail.com");
        imprimirPersona();
        service.registrarPersona(persona1);
        imprimirPersona();
        System.out.println("Fin del servicio Registrar personas WS");
    }
    
    private static void probarModificarPersona() {
        System.out.println("\nEjecutando el servicio Modificar persona WS");
        Persona pSearch = new Persona();
        pSearch.setId(6);
        persona1 = service.encontrarPersonaPorId(pSearch);
        System.out.print("Persona encontrada: ");
        imprimirPersona();
        persona1.setPaterno("PruebaModificada");
        System.out.print("Modificando apellido: ");
        imprimirPersona();
        service.modificarPersona(persona1);
        System.out.print("Persona modificada: ");
        imprimirPersona();
        
        System.out.println("Fin del servicio Modificar persona WS");
    }
    
    private static void probarEliminarPersona() {
        System.out.println("\nEjecutando el servicio Modificar persona WS");
        Persona pSearch = new Persona();
        pSearch.setId(6);
        persona1 = service.encontrarPersonaPorId(pSearch);
        System.out.print("Persona encontrada: ");
        imprimirPersona();
        System.out.print("Eliminando persona: ");
        imprimirPersona();
        service.eliminarPersona(persona1);
        System.out.println("Persona eliminada!");
        System.out.println("Fin del servicio Modificar persona WS");
    }
    
    private static void imprimirPersona() {
        String message = "Persona {"
                + "Id: " + persona1.getId()
                + ", Nombre: " + persona1.getNombre()
                + ", Paterno: " + persona1.getPaterno()
                + ", Email: " + persona1.getEmail()
                + "}";
        System.out.println(message);
    }
}
