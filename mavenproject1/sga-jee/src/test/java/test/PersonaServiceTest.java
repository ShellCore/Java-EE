package test;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.PersonaService;
import mx.com.gm.sga.servicio.UsuarioService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PersonaServiceTest {
    
    private PersonaService personaService;
    private UsuarioService usuarioService;
    
    EJBContainer container;
    
    @Before
    public void setup() throws Exception {
        container = EJBContainer.createEJBContainer();
        System.out.println("Abriendo contenedor embebido Glassfish");
        personaService = (PersonaService) container.getContext()
                .lookup("java:global/classes/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaService");
        usuarioService = (UsuarioService) container.getContext()
                .lookup("java:global/classes/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioService");
    }
    
    @Test
    public void testEJB() {
        testEJBPersonaService();
        testEJBUsuarioService();
    }
    
    private void testEJBPersonaService() {
        System.out.println("--- Iniciando test EJB PersonaService ---");
        assertTrue(personaService != null);
//        assertEquals(3, personaService.listaPersonas().size());
        
        System.out.println("El número de personas es igual a: " + personaService.listaPersonas().size());
        desplegarPersonas(personaService.listaPersonas());
        
        System.out.println("--- Fin test EJB PersonaService ---");
    }
    
    private void testEJBUsuarioService() {
        System.out.println("--- Iniciando test EJB UsuarioService ---");
        assertTrue(usuarioService != null);
//        assertEquals(1, usuarioService.listaUsuarios().size());
        
        System.out.println("El número de usuarios es igual a: " + usuarioService.listaUsuarios().size());
        desplegarUsuarios(usuarioService.listaUsuarios());
        
        System.out.println("--- Fin test EJB UsuarioService ---");
    }

    private void desplegarPersonas(List<Persona> list) {
        list.forEach(p -> {
            System.out.println(p);
        });
    }
    
    private void desplegarUsuarios(List<Usuario> list) {
        list.forEach(p -> {
            System.out.println(p);
        });
    }
}
