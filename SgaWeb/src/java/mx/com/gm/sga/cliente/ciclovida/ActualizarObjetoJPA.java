package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {
    
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
        Persona persona1 = em.find(Persona.class, 1);
        
        // 3. Terminamos transacción
        tx.commit();
        
        // Objeto en estado detached
        log.debug("Objeto recuperado: " + persona1);
        
        // 4. Modificación del objeto
        persona1.setMaterno("Nava");
        
        // 5. Inicia transacción 2
        tx2.begin();
        
        // 6. Ejecuta SQL de tipo SELECT. Como el objeto cuenta con el valor de
        // la llave primaria, la transacción actualiza la información de la base
        // de datos con la información modificada del objeto
        em.merge(persona1);
        
        // 7. Termina la transacción. Si existen cambios entre el objeto y la
        // información en la base de datos, se aplican dichos cambios
        tx2.commit();
        
        // Objeto en estado detached ya modificado
        log.debug("Objeto actualizado: " + persona1);
    }
}
