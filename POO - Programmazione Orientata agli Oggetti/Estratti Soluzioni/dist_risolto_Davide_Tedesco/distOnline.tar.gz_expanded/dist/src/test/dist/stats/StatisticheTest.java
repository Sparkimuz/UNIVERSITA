package dist.stats;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dist.pers.Attenta;
import dist.pers.Persona;
import dist.sim.Ambiente;
import dist.sim.Contatto;
import dist.sim.Coordinate;

public class StatisticheTest {

	@SuppressWarnings("unused")
	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		
	}

	@Test
	public void testProduciStatisticaVuoto() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		assertEquals(Collections.emptyMap(),stats.produciStatistiche(Collections.emptySet()));
	}

	@Test
	public void testProduciStatistica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Coordinate coo = new Coordinate(0, 0);
		Ambiente ambiente = new Ambiente();
		Persona p = new Attenta(ambiente);
		Contatto c = new Contatto(0, Collections.singleton(p), coo );
		Set<Contatto> lista = new HashSet<>();
		lista.add(c);
		assertEquals(1, stats.produciStatistiche(lista).size());
	}

	@Test
	public void testProduciStatisticaUnContatto() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Coordinate coo = new Coordinate(0, 0);
		Ambiente ambiente = new Ambiente();
		Persona p = new Attenta(ambiente);
		Contatto c = new Contatto(0, Collections.singleton(p), coo );
		Set<Contatto> lista = new HashSet<>();
		lista.add(c);
		assertEquals(1, stats.produciStatistiche(lista).size());
	}

	@Test
	public void testProduciStatisticaDueContatti() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Coordinate coo = new Coordinate(0, 0);
		Ambiente ambiente = new Ambiente();
		Persona p = new Attenta(ambiente);
		Persona p2 = new Attenta(ambiente);
		Contatto c = new Contatto(0,Collections.singleton(p) , coo );
		Contatto c1 = new Contatto(0,Collections.singleton(p2) , coo );
		Set<Contatto> lista = new HashSet<>();
		lista.add(c);
		lista.add(c1);
		assertEquals(true, stats.produciStatistiche(lista).containsKey(p2));
	}

	@Test
	public void testProduciStatisticaDueContattiUnaPersona() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Coordinate coo = new Coordinate(0, 0);
		Ambiente ambiente = new Ambiente();
		Persona p = new Attenta(ambiente);
		Persona p2 = new Attenta(ambiente);
		Contatto c = new Contatto(0,Collections.singleton(p) , coo );
		Contatto c1 = new Contatto(0,Collections.singleton(p2) , coo );
		Set<Contatto> lista = new HashSet<>();
		lista.add(c);
		lista.add(c1);
		assertEquals(2, stats.produciStatistiche(lista).size());
	}

}
