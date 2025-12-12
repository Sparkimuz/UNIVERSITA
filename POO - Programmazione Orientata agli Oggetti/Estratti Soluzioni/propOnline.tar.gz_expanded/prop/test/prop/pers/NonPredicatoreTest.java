package prop.pers;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prop.sim.Ambiente;
import prop.sim.Coordinate;

public class NonPredicatoreTest {

	private Ambiente a;
	private Persona pred;
	private Persona nonPred;
	private Persona pred2;


	@Before
	public void setUp() throws Exception {
		this.a = new Ambiente();
		this.pred = new Predicatore(a);
		this.pred2 = new Predicatore(a);
		this.nonPred = new NonPredicatore(a);
	}

	@After
	public void tearDown() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Field progIdP = Predicatore.class.getDeclaredField("progId");
		progIdP.setAccessible(true);
		progIdP.setInt(null, 0);

		Field progIdNP = NonPredicatore.class.getDeclaredField("progId");
		progIdNP.setAccessible(true);
		progIdNP.setInt(null, 0);
	}

	@Test
	public void mossaTest() {
		pred.setPosizione(new Coordinate(0, 0));
		nonPred.setPosizione(new Coordinate(1, 1));
		a.add(pred);
		a.add(nonPred);
		nonPred.mossa();
		assertEquals(new Coordinate(2, 2), nonPred.getPosizione());
	}

	@Test
	public void mossaTestSbagliata() {
		pred.setPosizione(new Coordinate(10, 10));
		pred2.setPosizione(new Coordinate(0, 0));
		nonPred.setPosizione(new Coordinate(1, 3));
		a.add(pred);
		a.add(pred2);
		a.add(nonPred);
		nonPred.mossa();
		assertEquals(new Coordinate(2, 4), nonPred.getPosizione());
		nonPred.mossa();
		assertEquals(new Coordinate(3, 5), nonPred.getPosizione());
		nonPred.mossa();
		assertEquals(new Coordinate(4, 6), nonPred.getPosizione());
	}	
}

