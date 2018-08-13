
package clientesga.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonaServiceWS", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonaServiceWS {


    /**
     * 
     * @return
     *     returns java.util.List<clientesga.ws.Persona>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listaPersonas", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.ListaPersonas")
    @ResponseWrapper(localName = "listaPersonasResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.ListaPersonasResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PersonaServiceWS/listaPersonasRequest", output = "http://servicio.sga.gm.com.mx/PersonaServiceWS/listaPersonasResponse")
    public List<Persona> listaPersonas();

}