package prop.stats;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import prop.pers.NonPredicatore;
import prop.pers.Persona;
import prop.pers.Predicatore;
import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;

public class StatisticheTest {

	@SuppressWarnings("unused")
	private Statistiche stats;
	private Ambiente a;
	private Contatto c;
	private Contatto c2;
	private Persona p;
	private Persona p2;
	private Persona p3;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.a = new Ambiente();
		this.p = new NonPredicatore(a);
		this.p2 = new Predicatore(a);
		this.p3 = new NonPredicatore(a);
		
	}
	
	@Test
	public void testProduciStatistica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Set<Persona> set = new HashSet<>();
		set.add(p);
		set.add(p2);
		c = new Contatto(1, set , new Coordinate(4, 6));
		List<Contatto> lista = Collections.singletonList(c);
		Map<Integer, Set<Contatto>> expected = new HashMap<>();
		expected.put(1, Collections.singleton(c));
		assertEquals(expected, stats.produciStatistiche(lista));
	}
	
	@Test
	public void testProduciStatisticaDueContatti() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Set<Persona> set = new HashSet<>();
		set.add(p);
		set.add(p2);
		Set<Persona> set2 = new HashSet<>();
		set2.add(p);
		set2.add(p2);
		set2.add(p3);
		c = new Contatto(1, set , new Coordinate(4, 6));
		c2 = new Contatto(1, set2 , new Coordinate(5, 6));
		List<Contatto> lista = new ArrayList<>();
		lista.add(c2);
		lista.add(c);
		Map<Integer, Set<Contatto>> expected = new TreeMap<>();
		Set<Contatto> contatti = new HashSet<>();
		contatti.add(c);
		contatti.add(c2);
		expected.put(1,contatti);
		assertEquals(expected, stats.produciStatistiche(lista));
	}

}
