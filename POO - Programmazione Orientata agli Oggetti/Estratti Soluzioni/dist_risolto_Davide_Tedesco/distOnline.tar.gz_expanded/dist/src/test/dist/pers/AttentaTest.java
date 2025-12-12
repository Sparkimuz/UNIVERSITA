package dist.pers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class AttentaTest {

	private Ambiente ambiente;
	private Attenta attenta;
	private Attenta a;
	private Distratta d;
	private Distratta d2;
	private Coordinate c;
	
	@Before
	public void setUp() {
		this.ambiente = new Ambiente();
		this.c = new Coordinate(4, 4);
		this.a = new Attenta(ambiente);
		this.d = new Distratta(ambiente);
		this.d2 = new Distratta(ambiente);
		this.attenta = new Attenta(ambiente);
		attenta.setPosizione(c);
		a.setPosizione(new Coordinate(3, 5));
		d.setPosizione(new Coordinate(3, 3));
		d2.setPosizione(new Coordinate(5, 5));
		ambiente.add(a);
		ambiente.add(d);
		ambiente.add(d2);
	}
	
	@Test
	public void mossaTest() {
		attenta.mossa();
		assertEquals(new Coordinate(5, 3), attenta.getPosizione());
	}
	
	//DA COMPLETARE CON ALTRI TEST
}
