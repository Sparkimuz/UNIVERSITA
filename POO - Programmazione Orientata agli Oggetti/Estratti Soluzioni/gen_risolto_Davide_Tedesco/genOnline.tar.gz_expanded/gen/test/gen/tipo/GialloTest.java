package gen.tipo;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import gen.sim.Ambiente;

public class GialloTest {
	
	private Giallo giallo;
	private Ambiente ambiente;
	private Giallo giallo2;
	private Verde verde;
	private Giallo giallo3;
	
	@Before
	public void setUp() {
		this.ambiente = new Ambiente();
		this.giallo = new Giallo(ambiente);
		this.giallo2 = new Giallo(ambiente);
		this.giallo3 = new Giallo(ambiente);
		ambiente.add(giallo);
		ambiente.add(giallo2);
		ambiente.add(giallo3);
	}
	
	@Test
	public void testDecidiProssimoObiettivoVerde() {
		this.verde = new Verde(ambiente);
		ambiente.add(verde);
		assertSame(verde.getClass(), giallo.decidiProssimoObiettivo().getClass());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDecidiProssimoObiettivoNessuno() {
		giallo.decidiProssimoObiettivo();
	}

}
