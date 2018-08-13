package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaApiCriteria {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        
        // Query utilizando el API de Criteria
        
        // 1. Consulta todas las personas
        log.debug("\n1. Consulta todas las personas");
        
        // a. El objeto EntityManager crea instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        // b. Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        // c. Se crea el objeto raíz del Query
        fromPersona = criteriaQuery.from(Persona.class);
        
        // d. Se selecciona lo necesario del from
        criteriaQuery.select(fromPersona);
        
        // e. Se crea el query TypeSafe (en tiempo de compilación se revisan que
        // los parámetros sean correctos)
        query = em.createQuery(criteriaQuery);
        
        // f. Se ejecuta la consulta
        List<Persona> list = query.getResultList();
        mostrarPersonas(list);
        
        // 2. 
        // a. Consulta de todas las personas con Id = 1
        // jpql = "select p from Persona p where p.id = 1";
        log.debug("\n2. Consulta de todas las personas con Id = 1");
        
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona)
                .where(cb.equal(fromPersona.get("id"), 1));
        persona = (Persona) em.createQuery(criteriaQuery)
                .getSingleResult();
        log.debug(persona);
        
        // b. Consukta de todas las personas con Id = 1 de forma dinámica
        log.debug("\n2. Consulta de todas las personas con Id = 1 de forma dinámica");
        
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        // La clase Predicate permite agregar varios criterios dinámicamente
        List<Predicate> criterios = new ArrayList<>();
        
        // Verificamos si tenemos varios criterios que agregar
        Integer idPersonaParam = null;
        idPersonaParam = 1;
        if (idPersonaParam != null) {
            ParameterExpression<Integer> px = cb.parameter(Integer.class, "id");
            criterios.add(cb.equal(fromPersona.get("id"), px));
        }
        
        // Se agregan los criterios
        if (criterios.isEmpty()) {
            throw new RuntimeException("Sin criteriaQuery");
        } else if (criterios.size() == 1) {
            criteriaQuery.where(criterios.get(0));
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        // Se crea el query con los criterios
        query = em.createQuery(criteriaQuery);
        if (idPersonaParam != null) {
            query.setParameter("id", idPersonaParam);
        }
        
        // Se ejectua el query
        persona = query.getSingleResult();
        log.debug(persona);
    }

    private static void mostrarPersonas(List<Persona> list) {
        list.forEach(element -> {
            System.out.println(element);
        });
    }
}
