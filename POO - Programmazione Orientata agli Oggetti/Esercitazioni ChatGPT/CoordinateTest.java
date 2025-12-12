import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;


public class CoordinateTest{

    @Test
    public void testEquals(){
        assertEquals("Non funziona", new Coordinate(0,0), new Coordiante(0,0));
    }

    @Test
    public void testSposta(){
        Coordinate Punto = new Coordinate(10, 30);
        Punto.Sposta(10, 10);
        assertTrue("Il punto non si è spostato correttamente", (Punto.x == 20 && Punto.y == 40));
    }

    @Test
    public void testDistanzaDa(){
        Coordinate Punto2 = new Coordinate(20, 10);
        Coordinate Punto3 = new Coordinate(10, 20);
        Punto2.distanzaDa(Punto3);
        assertTrue("La distanza è errata", int distanza = 14);

    }
}