package gen.stats;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import gen.sim.Scontro;
import gen.tipo.Animale;
import gen.tipo.Bianco;
import gen.tipo.Verde;

public class StatisticheTest {

	private Statistiche stats;
	private Scontro scontro;
	private Scontro scontro2;
	private Set<Scontro> scontri;
	private Set<Animale> animali;
	private Bianco animale;
	private Verde animale2;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.scontri = new HashSet<Scontro>();
		this.animali = new HashSet<Animale>();
		animali.add(animale);
		animali.add(animale2);
		this.scontro = new Scontro(animali);
		this.scontro2 = new Scontro(animali);
		scontri.add(scontro);
		scontri.add(scontro2);
	}
	
	@Test
	public void testScontriPerAnimaleVuoto() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		assertEquals(0, stats.scontriPerAnimale(Collections.emptySet()).size());
	}
	
	@Test
	public void testScontriPerUnAnimale() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		assertEquals(1, stats.scontriPerAnimale(scontri).size());
	}

}
