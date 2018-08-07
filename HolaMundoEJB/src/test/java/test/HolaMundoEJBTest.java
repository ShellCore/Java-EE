package test;

import beans.HolaMundoEJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HolaMundoEJBTest {
    
    private static EJBContainer container;
    private static Context context;
    private static HolaMundoEJB ejb;
    
    @Before
    public void initContainer() throws Exception {
        System.out.println("Iniciando EJB Container");
        container = EJBContainer.createEJBContainer();
        context = container.getContext();
        ejb = (HolaMundoEJB) context.lookup("java:global/classes/HolaMundoEJB!beans.HolaMundoEJB");
    }
    
    @Test
    public void testAddNumbers() {
        int data1 = 3;
        int data2 = 5;
        int result = ejb.sumar(data1, data2);
        Assert.assertEquals((data1 + data2), result);
        System.out.println("\nOperación terminada. Resultado: " + result + "\n");
    }
    
}
