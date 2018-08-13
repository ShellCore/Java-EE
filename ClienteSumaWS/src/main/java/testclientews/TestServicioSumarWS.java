package testclientews;

import clientews.servicio.ServicioSumarWS;
import clientews.servicio.ServicioSumarWSImplService;

public class TestServicioSumarWS {
    
    public static void main(String[] args) {
        ServicioSumarWS service = new ServicioSumarWSImplService().getServicioSumarWSImplPort();
        System.out.println("Ejectuando Servicio Sumar WS");
        int x = 1;
        int y = 2;
        System.out.println("Sumar: x:" + x + ", y:" + y);
        System.out.println("Resultado: " + service.sumar(x, y));
        System.out.println("Fin Servicio Sumar WS");
    }
    
}
