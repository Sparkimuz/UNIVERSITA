package prop.pers;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prop.sim.Ambiente;
import prop.sim.Coordinate;

public class PredicatoreTest {

	private Ambiente a;
	private Persona pred;
	private Persona nonPred;
	private Persona nonPred2;


	@Before
	public void setUp() throws Exception {
		this.a = new Ambiente();
		this.pred = new Predicatore(a);
		this.nonPred = new NonPredicatore(a);
		this.nonPred2 = new NonPredicatore(a);
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
		nonPred.setPosizione(new Coordinate(10, 10));
		a.add(pred);
		a.add(nonPred);
		for(int i=1;i<10;i++) {
			pred.mossa();
			assertEquals(new Coordinate(i, i), pred.getPosizione());
		}
	}
	@Test
	public void mossaTestSbagliata() {
		pred.setPosizione(new Coordinate(10, 10));
		nonPred.setPosizione(new Coordinate(0, 0));
		nonPred2.setPosizione(new Coordinate(1, 3));
		a.add(pred);
		a.add(nonPred);
		for(int i=10;i<1;i--) {
			pred.mossa();
			assertEquals(new Coordinate(i, i), pred.getPosizione());
		}
	}
}
