
package clientesga.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientesga.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListaPersonasResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "listaPersonasResponse");
    private final static QName _ModificarPersona_QNAME = new QName("http://servicio.sga.gm.com.mx/", "modificarPersona");
    private final static QName _EncontrarPersonaPorIdResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarPersonaPorIdResponse");
    private final static QName _ListaPersonas_QNAME = new QName("http://servicio.sga.gm.com.mx/", "listaPersonas");
    private final static QName _RegistrarPersona_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarPersona");
    private final static QName _EliminarPersona_QNAME = new QName("http://servicio.sga.gm.com.mx/", "eliminarPersona");
    private final static QName _EliminarPersonaResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "eliminarPersonaResponse");
    private final static QName _EncontrarPersonaPorId_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarPersonaPorId");
    private final static QName _ModificarPersonaResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "modificarPersonaResponse");
    private final static QName _RegistrarPersonaResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarPersonaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientesga.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EliminarPersona }
     * 
     */
    public EliminarPersona createEliminarPersona() {
        return new EliminarPersona();
    }

    /**
     * Create an instance of {@link RegistrarPersona }
     * 
     */
    public RegistrarPersona createRegistrarPersona() {
        return new RegistrarPersona();
    }

    /**
     * Create an instance of {@link ListaPersonas }
     * 
     */
    public ListaPersonas createListaPersonas() {
        return new ListaPersonas();
    }

    /**
     * Create an instance of {@link EncontrarPersonaPorIdResponse }
     * 
     */
    public EncontrarPersonaPorIdResponse createEncontrarPersonaPorIdResponse() {
        return new EncontrarPersonaPorIdResponse();
    }

    /**
     * Create an instance of {@link ListaPersonasResponse }
     * 
     */
    public ListaPersonasResponse createListaPersonasResponse() {
        return new ListaPersonasResponse();
    }

    /**
     * Create an instance of {@link ModificarPersona }
     * 
     */
    public ModificarPersona createModificarPersona() {
        return new ModificarPersona();
    }

    /**
     * Create an instance of {@link EncontrarPersonaPorId }
     * 
     */
    public EncontrarPersonaPorId createEncontrarPersonaPorId() {
        return new EncontrarPersonaPorId();
    }

    /**
     * Create an instance of {@link ModificarPersonaResponse }
     * 
     */
    public ModificarPersonaResponse createModificarPersonaResponse() {
        return new ModificarPersonaResponse();
    }

    /**
     * Create an instance of {@link RegistrarPersonaResponse }
     * 
     */
    public RegistrarPersonaResponse createRegistrarPersonaResponse() {
        return new RegistrarPersonaResponse();
    }

    /**
     * Create an instance of {@link EliminarPersonaResponse }
     * 
     */
    public EliminarPersonaResponse createEliminarPersonaResponse() {
        return new EliminarPersonaResponse();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPersonasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "listaPersonasResponse")
    public JAXBElement<ListaPersonasResponse> createListaPersonasResponse(ListaPersonasResponse value) {
        return new JAXBElement<ListaPersonasResponse>(_ListaPersonasResponse_QNAME, ListaPersonasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "modificarPersona")
    public JAXBElement<ModificarPersona> createModificarPersona(ModificarPersona value) {
        return new JAXBElement<ModificarPersona>(_ModificarPersona_QNAME, ModificarPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarPersonaPorIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarPersonaPorIdResponse")
    public JAXBElement<EncontrarPersonaPorIdResponse> createEncontrarPersonaPorIdResponse(EncontrarPersonaPorIdResponse value) {
        return new JAXBElement<EncontrarPersonaPorIdResponse>(_EncontrarPersonaPorIdResponse_QNAME, EncontrarPersonaPorIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPersonas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "listaPersonas")
    public JAXBElement<ListaPersonas> createListaPersonas(ListaPersonas value) {
        return new JAXBElement<ListaPersonas>(_ListaPersonas_QNAME, ListaPersonas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarPersona")
    public JAXBElement<RegistrarPersona> createRegistrarPersona(RegistrarPersona value) {
        return new JAXBElement<RegistrarPersona>(_RegistrarPersona_QNAME, RegistrarPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "eliminarPersona")
    public JAXBElement<EliminarPersona> createEliminarPersona(EliminarPersona value) {
        return new JAXBElement<EliminarPersona>(_EliminarPersona_QNAME, EliminarPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "eliminarPersonaResponse")
    public JAXBElement<EliminarPersonaResponse> createEliminarPersonaResponse(EliminarPersonaResponse value) {
        return new JAXBElement<EliminarPersonaResponse>(_EliminarPersonaResponse_QNAME, EliminarPersonaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarPersonaPorId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarPersonaPorId")
    public JAXBElement<EncontrarPersonaPorId> createEncontrarPersonaPorId(EncontrarPersonaPorId value) {
        return new JAXBElement<EncontrarPersonaPorId>(_EncontrarPersonaPorId_QNAME, EncontrarPersonaPorId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "modificarPersonaResponse")
    public JAXBElement<ModificarPersonaResponse> createModificarPersonaResponse(ModificarPersonaResponse value) {
        return new JAXBElement<ModificarPersonaResponse>(_ModificarPersonaResponse_QNAME, ModificarPersonaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarPersonaResponse")
    public JAXBElement<RegistrarPersonaResponse> createRegistrarPersonaResponse(RegistrarPersonaResponse value) {
        return new JAXBElement<RegistrarPersonaResponse>(_RegistrarPersonaResponse_QNAME, RegistrarPersonaResponse.class, null, value);
    }

}
