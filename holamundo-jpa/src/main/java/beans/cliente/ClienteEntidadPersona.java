package beans.cliente;

import beans.dominio.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClienteEntidadPersona {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // Inicia la transacción
        tx.begin();
        
        // No se debe de especificar el Id, ya que se genera en automático
        Persona persona1 = new Persona("Jose", "Jose", "Prince", "jjose@mail.com", "12345678");
        log.debug("Objeto a persistir: " + persona1);
        // Persistencia del objeto
        em.persist(persona1);
        // Terminamos la transacción
        tx.commit();
        log.debug("Objeto persistido: " + persona1);
        em.close();
    }
}
