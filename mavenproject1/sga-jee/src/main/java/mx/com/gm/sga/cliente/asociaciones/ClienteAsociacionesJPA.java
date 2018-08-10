package mx.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClienteAsociacionesJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> list = em.createNamedQuery("Persona.findAll")
                .getResultList();
        
        // Cerramos la conexión
        em.close();
        
        // Mostramos la lista de personas
        imprimirPersonas(list);
    }

    private static void imprimirPersonas(List<Persona> list) {
        list.forEach(p -> {
            log.debug(p);
            p.getUsuarioList().forEach(u -> {
                log.debug(u);
            });
        });
    }
    
}
