package dist.stats;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dist.pers.Distratta;
import dist.pers.Persona;
import dist.sim.Ambiente;
import dist.sim.Contatto;
import dist.sim.Coordinate;
import dist.sim.Simulatore;

public class StatisticheTest {

	private Simulatore simulatore;
	@SuppressWarnings("unused")
	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}
	
	@Test
	public void testProduciStatisticaMappaVuota() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Map<Persona,List<Contatto>> expected = Collections.EMPTY_MAP;

		assertEquals(expected, this.stats.produciStatistiche(this.simulatore.getContatti()));
	}

	@Test
	public void testUnContatto() {
		Map<Persona,List<Contatto>> mappa = new HashMap<>();
		Coordinate coor= new Coordinate(2, 2);
		List<Contatto> contatti = new ArrayList<>();
		Ambiente ambiente = new Ambiente();
		Persona p2 = new Distratta(ambiente);
		Set<Persona> per  = new HashSet<Persona>();
		per.add(p2);
		Contatto con = new Contatto(23, per, coor);
		contatti.add(con);
		mappa.put(p2, contatti);
		this.simulatore.add(con);
		
		String expected = new String("{"+p2.toString()+"=[[Contatto: era 23, #coinvolti 1]]}");
		assertEquals(expected, this.stats.produciStatistiche(this.simulatore.getContatti()).toString());
	}	

}
