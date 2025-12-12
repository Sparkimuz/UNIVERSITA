package testPack;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import codice.*;

public class EssereViventeTest{

	@Test
    public void PersonaMuoviTest(){
        Coordinate origine = new Coordinate(0,0);
        Persona mario = new Persona(origine);

        mario.muovi(Direzione.NORD);
        assertEquals("Non si è mosso nella direzione giusta", 1, mario.getPosizione().getY());
        assertEquals("Non si è mosso nella direzione giusta", 0, mario.getPosizione().getX());
        mario.muovi(Direzione.EST);
        assertEquals("Non si è mosso nella direzione giusta", 1, mario.getPosizione().getY());
        assertEquals("Non si è mosso nella direzione giusta", 1, mario.getPosizione().getX());

    }

	@Test
    public void AnimaleMuoviTest(){
        Coordinate origine = new Coordinate(0,0);
        Animale birillo = new Animale(origine);

        birillo.muovi(Direzione.NORD);
        assertEquals("Non si è mosso nella direzione giusta", 2, birillo.getPosizione().getY());
        assertEquals("Non si è mosso nella direzione giusta", 0, birillo.getPosizione().getX());
        birillo.muovi(Direzione.EST);
        assertEquals("Non si è mosso nella direzione giusta", 2, birillo.getPosizione().getY());
        assertEquals("Non si è mosso nella direzione giusta", 2, birillo.getPosizione().getX());

    }
	@Test
    public void ListaEsseriViventiTest(){
        List<EssereVivente> ListaEsseriViventi = new ArrayList<>();

        ListaEsseriViventi.add(new Persona(new Coordinate(0,0)));
        ListaEsseriViventi.add(new Animale(new Coordinate(0,0)));

        for(EssereVivente essere : ListaEsseriViventi){
            essere.muovi(Direzione.NORD);
            int yGiusta = (essere instanceof Persona) ? 1 : 2;
            assertEquals("L'essere non si è mosso per i passi giusti", yGiusta, essere.getPosizione().getY());


        }

    }
}