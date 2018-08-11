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

@WebServlet("/ListarPersonas")
public class ServletControlador extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private PersonaService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Persona> personas = service.listaPersonas();
        req.setAttribute("personas", personas);
        req.getRequestDispatcher("listarPersonas.jsp")
                .forward(req, resp);
    }
}
