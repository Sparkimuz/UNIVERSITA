package dist.pers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class DistrattaTest {

	private Ambiente ambiente;
	private Distratta distratta;
	private Attenta a;
	private Distratta d;
	private Distratta d2;
	private Coordinate c;
	
	@Before
	public void setUp() {
		this.ambiente = new Ambiente();
		this.c = new Coordinate(4, 4);
		this.distratta = new Distratta(ambiente);
		distratta.setPosizione(c);
		this.a = new Attenta(ambiente);
		this.d = new Distratta(ambiente);
		this.d2 = new Distratta(ambiente);
		a.setPosizione(new Coordinate(3, 5));
		d.setPosizione(new Coordinate(3, 3));
		d2.setPosizione(new Coordinate(5, 5));
		ambiente.add(a);
		ambiente.add(d);
		ambiente.add(d2);
		
	}
	@Test
	public void mossaTest() {
		distratta.mossa();
		List<Coordinate> possibili = new ArrayList<>();
		possibili.add(new Coordinate(3, 5));
		possibili.add(new Coordinate(3, 3));
		possibili.add(new Coordinate(5, 5));
		possibili.add(new Coordinate(5, 3));
		assertTrue(possibili.contains(distratta.getPosizione()));
	}
}
