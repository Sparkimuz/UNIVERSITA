import static org.junit.Assert.*;
import org.junit.Test;

public class VeicoloTest{

    public class AutoElettricaTest{
        @Test
        public void decidiProssimaDestinazioneTest(){
            AutoElettrica auto = new AutoElettrica(new Coordinate(0,0));
            Coordinate destinazione = auto.decidiProssimaDestinazione();

            assertTrue("La X è fuori dal raggio di 5", destinazione.getX() >= -5 && destinazione.getX() <= 5);
            assertTrue("La Y è fuori dal raggio di 5", destinazione.getY() >= -5 && destinazione.getY() <= 5);
        }
    }

    public class AutoBenzinaTest{
        @Test
        public void decidiProssimaDestinazioneTest(){
            AutoBenzina auto = new AutoBenzina(new Coordinate(0,0));
            Coordinate destinazione = auto.decidiProssimaDestinazione();

            assertTrue("La X è fuori dal raggio di 10", -11<destinazione.getX()<11);
            assertTrue("La Y è fuori dal raggio di 10", -11<destinazione.getY()<11);
        }
    }
    @Test
    public void simulaMovimentoTest(){
        AutoElettrica auto = new AutoElettrica(new Coordinate(0,0));
        Coordinate destinazione = auto.decidiProssimaDestinazione();
        auto.simulaMovimento(destinazione);

        assertEquals("L'auto non è arrivata a destinazione", destinazione, auto.getPosizione);
        assertTrue("La posizione X è fuori dal raggio di 10", -11<auto.getPosizione<11);
        assertTrue("La posizione Y è fuori dal raggio di 10", -11<auto.getPosizione<11);
    }


}

