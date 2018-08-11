package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

@WebServlet({"/ServletControlador", "/ListarPersonas"})
public class ServletControlador extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private PersonaService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String accion = req.getParameter("accion");
        if (accion != null && accion.equals("editar")) {
            String idPersona = req.getParameter("id");
            int id = 0;
            if (idPersona != null) {
                id = Integer.parseInt(idPersona);
                Persona persona = new Persona(id);
                persona = service.encontrarPersonaPorId(persona);
                
                req.setAttribute("persona", persona);
                req.getRequestDispatcher("editarPersona.jsp")
                        .forward(req, resp);
            }
        } else {
            listarPersonas(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch(accion) {
                case "agregar":
                    agregarPersona(req, resp);
                    break;
                case "modificar":
                    modificarPersona(req, resp);
                    break;
            }
        }
        listarPersonas(req, resp);
    }
    
    private void listarPersonas (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Persona> personas = service.listaPersonas();
        req.setAttribute("personas", personas);
        req.getRequestDispatcher("listarPersonas.jsp")
                .forward(req, resp);
    }
    
    private void agregarPersona(HttpServletRequest req, HttpServletResponse resp) {
        
        String nombre = req.getParameter("nombre");
        String paterno = req.getParameter("paterno");
        String materno = req.getParameter("materno");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        
        Persona p = new Persona(nombre, paterno, materno, email, telefono);
        try {
            service.registrarPersona(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void modificarPersona(HttpServletRequest req, HttpServletResponse resp) {
        String btnGuardar = req.getParameter("guardar");
        String btnEliminar = req.getParameter("eliminar");
        
        if (btnGuardar != null) {
            guardarPersona(req, resp);
        } else if (btnEliminar != null) {
            eliminarPersona(req, resp);
        }
    }
    
    private void guardarPersona(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        String paterno = req.getParameter("paterno");
        String materno = req.getParameter("materno");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        
        Persona persona = new Persona(nombre, paterno, materno, email, telefono);
        persona.setId(Integer.parseInt(id));
        
        try {
            service.modificarPersona(persona);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void eliminarPersona(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        
        Persona persona = new Persona(Integer.parseInt(id));
        
        try {
            service.eliminarPersona(persona);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
