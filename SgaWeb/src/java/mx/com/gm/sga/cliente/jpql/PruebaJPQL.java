package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona p = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        // 1. Consulta de todas las personas
        log.debug("\n1. Consulta de todas las personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        // 2. Consulta de las personas con id = 1
        log.debug("\n2. Consulta de las personas con id = 1");
        jpql = "select p from Persona p where p.id = 1";
        p = (Persona) em.createQuery(jpql).getSingleResult();
        log.debug(p);
        
        // 3. Consulta de la persona por nombre
        log.debug("\n3. Consulta de la persona por nombre");
        jpql = "select p from Persona p where p.nombre = 'Jose'";
        p = (Persona) em.createQuery(jpql).getSingleResult();
        log.debug(p);
        
        // 4. Consulta de datos individuales. Se crea un arreglo (tupla) de tipo
        // Object de 3 columnas
        log.debug("\n4. Consulta de datos individuales. Se crea un arreglo (tupla) de tipo Object de 3 columnas");
        jpql = "select p.nombre as Nombre, p.paterno as ApPaterno, p.materno as ApMaterno from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apPaterno = (String) tupla[1];
            String apMaterno = (String) tupla[2];
            log.debug("nom: " + nombre + ", apPat: " + apPaterno + ", apMat: " + apMaterno);
        }
        
        // 5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo 
        // Object con 2 columnas
        log.debug("\n5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas");
        jpql = "select p, p.id from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            p = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            log.debug("Objeto persona: " + p);
            log.debug("Id persona: " + idPersona);
        }
        
        // 6. Consulta de todas las personas
        log.debug("\n6. Consulta de todas las personas");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.id) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        // 7. Regresa el valor mínimo y máximo del idPersona (Scalar results)
        log.debug("\n7. Regresa el valor mínimo y máximo del idPersona (Scalar results)");
        jpql = "select min(p.id) as MinId, max(p.id) as MaxId, count(p.id) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            log.debug("idMin: " + idMin + ", idMax: " + idMax + ", count: " + count);
        }
        
        // 8. Cuenta los nombres de las personas que son distintos
        log.debug("\n8. Cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("No. de personas con nombre distinto: " + contador);
        
        // 9. Concatena y convierte a mayúsculas el nombre y apellido (depende 
        // de la base de datos)
        log.debug("\n9. Concatena y convierte a mayúsculas el nombre y apellido (depende de la base de datos)");
        jpql = "select CONCAT (p.nombre, ' ', p.paterno) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        nombres.forEach(nombreCompleto -> {
            log.debug(nombreCompleto);
        });
        
        // 10. Obtiene el objeto persona con id igual al parámetro
        log.debug("\n10. Obtiene el objeto persona con id igual al parámetro");
        int id = 1;
        jpql = "select p from Persona p where p.id = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", id);
        p = (Persona) q.getSingleResult();
        log.debug(p);
        
        // 11. Obtiene las personas que contenga una letra A, sin importar
        // mayúsculas o minúsculas
        log.debug("\n11. Obtiene las personas que contenga una letra A, sin importar mayúsculas o minúsculas");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:param1)";
        String cadena = "%a%"; // Es el caractér que utilizamos para el like
        q = em.createQuery(jpql);
        q.setParameter("param1", cadena);
        personas = q.getResultList();
        mostrarPersonas(personas);
        
        // 12. Uso del between
        log.debug("\n12. Uso del between");
        jpql = "select p from Persona p where p.id between 1 and 2";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        // 13. Uso del ordenamiento
        log.debug("\n13. Uso del ordenamiento");
        jpql = "select p from Persona p where p.id > 3 order by p.nombre desc, p.paterno desc";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        // 14. Uso de un subquery (el soporte de esta funcionalidad depende de 
        // la base de datos utilizada)
        log.debug("\n14. Uso de un subquery (el soporte de esta funcionalidad depende de la base de datos utilizada)");
        jpql = "select p from Persona p where p.id in ( select min(p1.id) from Persona p1 )";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        // 15. Uso de join con LAZY loading
        log.debug("\n15. Uso del join con LAZY loading");
        jpql = "select u from Usuario u join u.idPersona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
        // 16. Uso de left join con EAGER loading
        log.debug("\n16. Uso de left join con EAGER loading");
        jpql = "select u from Usuario u left join fetch u.idPersona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        personas.forEach(p -> {
            log.debug(p);
        });
    }
    
    private static void mostrarUsuarios(List<Usuario> usuarios) {
        usuarios.forEach(u -> {
            log.debug(u);
        });
    }
}
