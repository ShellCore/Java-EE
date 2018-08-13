
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
    private final static QName _ListaPersonas_QNAME = new QName("http://servicio.sga.gm.com.mx/", "listaPersonas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientesga.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListaPersonas }
     * 
     */
    public ListaPersonas createListaPersonas() {
        return new ListaPersonas();
    }

    /**
     * Create an instance of {@link ListaPersonasResponse }
     * 
     */
    public ListaPersonasResponse createListaPersonasResponse() {
        return new ListaPersonasResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPersonas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "listaPersonas")
    public JAXBElement<ListaPersonas> createListaPersonas(ListaPersonas value) {
        return new JAXBElement<ListaPersonas>(_ListaPersonas_QNAME, ListaPersonas.class, null, value);
    }

}
