package prop.stats;

import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import prop.sim.Contatto;
import prop.sim.Simulatore;
import prop.stats.Statistiche;

public class StatisticheTest {

	@SuppressWarnings("unused")
	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}
	
	@Test
	public void testProduciStatistica() {
		Map<Integer, Set<Contatto>> mappa = new HashMap<Integer, Set<Contatto>>();
		Simulatore sim = new Simulatore();
		sim.simula();
		Contatto c1 = new Contatto (sim.getPasso(), sim.getPersona())
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		fail("DA COMPLETARE");
	}

}
