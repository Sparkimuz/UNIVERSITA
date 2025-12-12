package war;

import static war.costanti.CostantiSimulazione.DELTA_TRACCIA;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import war.tank.Explorer;

public class CampoTest {
	
	private Campo campo;
	
	@Before
	public void setUp() throws Exception {
		this.campo = new Campo(3);
		Explorer explorer = new Explorer(campo);
		explorer.setPosizione(new Coordinate(1,1));
		this.campo.lasciaTraccia(explorer);
		
	}

	@Test
	public void test() {
		assertEquals("Errore", DELTA_TRACCIA, this.campo.rilevaTracciaVerso(new Coordinate(1, 0), new Direzione(0,1)));
	}

}
