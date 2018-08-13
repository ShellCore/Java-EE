package mx.com.gm.sga.servicio.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

@Path("/personas")
@Stateless
public class PersonaServiceRS {
    
    @EJB
    private PersonaService service;
    
    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public List<Persona> listaPersonas() {
        return service.listaPersonas();
    }
    
    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    @Path("{id}")
    public Persona encontrarPersonaPorId(@PathParam("id") int id) {
        return service.encontrarPersonaPorId(new Persona(id));
    }
    
    @POST
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public Response agregarPersona(Persona persona) {
        try {
            service.registrarPersona(persona);
            return Response.ok()
                    .entity(persona)
                    .build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    
    @PUT
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        try {
            Persona persona = service.encontrarPersonaPorId(new Persona(id));
            if (persona != null) {
                service.modificarPersona(personaModificada);
                return Response.ok()
                        .entity(personaModificada)
                        .build();
            } else {
                return Response.status(Status.NOT_FOUND)
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminaPersonaPorId(@PathParam("id") int id) {
        try {
            service.eliminarPersona(new Persona(id));
            return Response.ok()
                    .build();
        } catch (Exception e) {
            return Response.status(404)
                    .build();
        }
    }
}
