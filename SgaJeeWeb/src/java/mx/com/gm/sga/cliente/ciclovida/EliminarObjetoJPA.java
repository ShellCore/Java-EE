package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        EntityTransaction tx2 = em.getTransaction();
        
        // 1. Inicia transacción
        tx.begin();
        
        // 2. Ejecuta SQL de tipo SELECT
        // El id proporcionado debe existir en la base de datos
        Persona persona1 = em.find(Persona.class, 4);
        
        // 3. Terminamos transacción
        tx.commit();
        
        // Objeto en estado detached
        log.debug("Objeto recuperado: " + persona1);
        
        // 4. Modificación del objeto
        persona1.setMaterno("Nava");
        
        // 5. Inicia transacción 2
        tx2.begin();
        
        // 6. Ejecuta SQL de tipo DELETE
        em.remove(persona1);
        
        // 7. Termina la transacción. Al momento de hacer commit, se realiza la
        // eliminación del mismo en la base de datos
        tx2.commit();
        
        // Objeto en estado detached ya modificado. Ya no es posible
        // sincronizarlo en otra transacción. Solo está en memoria, pero al
        // terminar el método se eliminará
        log.debug("Objeto eliminado: " + persona1);
    }
}
