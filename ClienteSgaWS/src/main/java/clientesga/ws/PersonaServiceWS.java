
package clientesga.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
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

    /**
     * 
     * @param arg0
     * @return
     *     returns clientesga.ws.Persona
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarPersonaPorId", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.EncontrarPersonaPorId")
    @ResponseWrapper(localName = "encontrarPersonaPorIdResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.EncontrarPersonaPorIdResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PersonaServiceWS/encontrarPersonaPorIdRequest", output = "http://servicio.sga.gm.com.mx/PersonaServiceWS/encontrarPersonaPorIdResponse")
    public Persona encontrarPersonaPorId(
        @WebParam(name = "arg0", targetNamespace = "")
        Persona arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registrarPersona", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.RegistrarPersona")
    @ResponseWrapper(localName = "registrarPersonaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.RegistrarPersonaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PersonaServiceWS/registrarPersonaRequest", output = "http://servicio.sga.gm.com.mx/PersonaServiceWS/registrarPersonaResponse")
    public void registrarPersona(
        @WebParam(name = "arg0", targetNamespace = "")
        Persona arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "modificarPersona", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.ModificarPersona")
    @ResponseWrapper(localName = "modificarPersonaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.ModificarPersonaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PersonaServiceWS/modificarPersonaRequest", output = "http://servicio.sga.gm.com.mx/PersonaServiceWS/modificarPersonaResponse")
    public void modificarPersona(
        @WebParam(name = "arg0", targetNamespace = "")
        Persona arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "eliminarPersona", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.EliminarPersona")
    @ResponseWrapper(localName = "eliminarPersonaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientesga.ws.EliminarPersonaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PersonaServiceWS/eliminarPersonaRequest", output = "http://servicio.sga.gm.com.mx/PersonaServiceWS/eliminarPersonaResponse")
    public void eliminarPersona(
        @WebParam(name = "arg0", targetNamespace = "")
        Persona arg0);

}
