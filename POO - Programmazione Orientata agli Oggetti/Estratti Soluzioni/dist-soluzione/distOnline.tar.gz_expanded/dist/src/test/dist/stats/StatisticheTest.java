package dist.stats;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dist.pers.Attenta;
import dist.pers.Distratta;
import dist.pers.Persona;
import dist.sim.Ambiente;
import dist.sim.Contatto;
import dist.sim.Coordinate;

public class StatisticheTest {

	@SuppressWarnings("unused")
	
	private Statistiche stats;
	private Set<Contatto> contatti;
	private Map<Persona, List<Contatto>> mappa;
	private Ambiente a1;
	private Set<Persona> pe;
	private Persona p1;
	private Persona p2;
	private Coordinate coo;
	private Contatto c1;
	
	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.contatti = new LinkedHashSet<Contatto>();
		this.coo = new Coordinate(0, 0);
		this.pe = new TreeSet<Persona>();
		this.a1 = new Ambiente();
		this.p1 = new Attenta(a1
				);
		this.p2 = new Distratta(a1);
		this.pe.add(p1);
		this.pe.add(p2);
		this.c1 = new Contatto(23, pe, coo);
		this.contatti.add(this.c1);
		this.mappa = stats.produciStatistiche(this.contatti);
	}
	
	@After
	public void tearDown() {
		this.mappa.clear();
		this.contatti.clear();
		this.pe.clear();
	}
	
	@Test
	public void testProduciStatisticaNull() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		this.contatti = Collections.EMPTY_SET;
		assertEquals(Collections.EMPTY_MAP,stats.produciStatistiche(this.contatti));
	}
	
	@Test
	public void testProduciStatisticaDueContatti() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Coordinate coo1 = new Coordinate(0, 0);
		Persona p3 = new Distratta(this.a1);
		pe.add(p3);
		Contatto c2 = new Contatto(65, pe, coo1);
		this.contatti.add(c2);
		this.mappa = stats.produciStatistiche(this.contatti);
		assertEquals(2, this.mappa.size());
	}
	
	@Test
	public void testProduciStatisticaUnContatto() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		assertEquals(1, this.mappa.size());
	}

	

}
