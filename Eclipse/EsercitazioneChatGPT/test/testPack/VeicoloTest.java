package testPack;
import codice.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class VeicoloTest{
        @Test
        public void decidiProssimaDestinazioneElettricaTest(){
            AutoElettrica auto = new AutoElettrica(new Coordinate(0,0));
            Coordinate destinazione = auto.decidiProssimaDestinazione();

            assertTrue("La X è fuori dal raggio di 5", destinazione.getX() >= -5 && destinazione.getX() <= 5);
            assertTrue("La Y è fuori dal raggio di 5", destinazione.getY() >= -5 && destinazione.getY() <= 5);
        }
        @Test
        public void decidiProssimaDestinazioneBenzinaTest(){
            AutoBenzina auto = new AutoBenzina(new Coordinate(0,0));
            Coordinate destinazione = auto.decidiProssimaDestinazione();

            assertTrue("La X è fuori dal raggio di 10", destinazione.getX()<11 && destinazione.getX()>-11);
            assertTrue("La Y è fuori dal raggio di 10", destinazione.getY()<11 && destinazione.getY()>-11);
        }
    @Test
    public void simulaMovimentoTest(){
        AutoElettrica auto = new AutoElettrica(new Coordinate(0,0));
        Coordinate destinazione = auto.decidiProssimaDestinazione();
        auto.simulaMovimento(destinazione);

        assertEquals("L'auto non è arrivata a destinazione", destinazione, auto.getPosizione());
    }


}
