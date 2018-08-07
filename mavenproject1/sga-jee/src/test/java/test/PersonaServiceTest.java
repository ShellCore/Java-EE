package test;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PersonaServiceTest {
    
    private PersonaService service;
    
    @Before
    public void setup() throws Exception {
        EJBContainer container = EJBContainer.createEJBContainer();
        service = (PersonaService) container.getContext()
                .lookup("java:global/classes/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaService");
    }
    
    @Test
    public void testEJBPersonaService() {
        System.out.println("--- Iniciando test EJB PersonaService ---");
        assertTrue(service != null);
        assertEquals(2, service.listaPersonas().size());
        
        System.out.println("El número de personas es igual a: " + service.listaPersonas().size());
        desplegarPersonas(service.listaPersonas());
        
        System.out.println("--- Fin test EJB PersonaService ---");
    }

    private void desplegarPersonas(List<Persona> list) {
        list.forEach(p -> {
            System.out.println(p);
        });
    }
}
