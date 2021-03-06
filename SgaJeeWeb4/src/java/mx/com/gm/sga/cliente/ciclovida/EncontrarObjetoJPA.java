package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncontrarObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // 1. Inicia la transacción
        tx.begin();
        
        // 2. Ejecuta SQL de tipo SELECT
        Persona persona1 = em.find(Persona.class, 1);
        
        // 3. Termina transacción
        tx.commit();
        
        // Objeto en estado detached
        log.debug("Objeto recuperado: " + persona1);
    }
    
}
