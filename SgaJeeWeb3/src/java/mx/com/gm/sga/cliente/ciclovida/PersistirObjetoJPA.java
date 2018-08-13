package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistirObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // Inicia la transacción
        
        // 1. Crea objeto nuevo
        // Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro", "Luna", "Gomez", "pluna@mail.com", "12354569");
        
        // 2. Inicia la transacción
        tx.begin();
        
        // 3. Ejecuta SQL
        em.persist(persona1);
        
        // 4. Commit/Rollback
        tx.commit();
        
        // Objeto en estado detached
        log.debug("Objeto persistido: " + persona1);
        
        // Cerramos el Entity Manager
        em.close();
    }
    
}
