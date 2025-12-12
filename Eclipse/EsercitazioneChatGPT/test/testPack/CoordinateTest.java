package testPack;

import static org.junit.Assert.*;
import org.junit.Test;

import codice.Coordinate;


public class CoordinateTest{

    @Test
    public void testEquals(){
        assertEquals("Non funziona", new Coordinate(0,0), new Coordinate(0,0));
    }

    @Test
    public void testSposta(){
        Coordinate nuovoPunto = new Coordinate(10, 30);
        nuovoPunto.Sposta(10, 10);
        assertEquals("Il punto non si è spostato correttamente in x", 20, nuovoPunto.getX());
        assertEquals("Il punto non si è spostato correttamente in y", 40, nuovoPunto.getY());    
        }

    @Test
    public void testDistanzaDa(){
        Coordinate Punto2 = new Coordinate(20, 10);
        Coordinate Punto3 = new Coordinate(10, 20);
        int distanza = Punto2.distanzaDa(Punto3);
        assertTrue("La distanza è errata", distanza == 14);

    }
}
