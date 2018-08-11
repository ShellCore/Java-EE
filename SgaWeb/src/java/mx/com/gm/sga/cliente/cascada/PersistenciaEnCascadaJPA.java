package mx.com.gm.sga.cliente.cascada;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistenciaEnCascadaJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // 1. Crea objeto nuevo
        // Objeto en estado transitivo
        Persona p = new Persona("Hugo", "Sanchez", "Pinto", "hsanchez@mail.com", "98765432");
        
        // Creamos el objeto usuario
        Usuario u  = new Usuario("hsanchez", "toor", p);
        
        // 2. Inicia la transacción
        tx.begin();
        
        // 3. Ejecuta SQL
        // Nota. Solo se persiste el objeto usuario, ya que se persiste el
        // objeto persona por cascada
        em.persist(u);
        
        // 4. Commit/Rollback
        tx.commit();
        
        // Objetos en estado Detached
        log.debug("Objeto Usuario persistido: " + u);
        log.debug("Objeto Persona persistido: " + p);
        
        // Cerramos el Entity Manager
        em.close();
    }
}
