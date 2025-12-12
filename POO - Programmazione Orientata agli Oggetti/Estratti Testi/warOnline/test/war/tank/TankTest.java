package war.tank;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import war.Campo;

/** 
 * Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 */
public class TankTest {

	private Campo campo;
	
	@Before
	public void setUp() throws Exception {
		this.campo = new Campo();
		Factory.reset();
	}
	
	@After
	public void tearDown() throws Exception{
		Factory.reset();
	}

	@Test
	public void testIdProgressiviPerIlPrimoTipoDinamico() {
		Shooter shooter1 = new Shooter(campo);
        Shooter shooter2 = new Shooter(campo);
        
        assertEquals("ID del primo Shooter non è 0", 0, shooter1.getId());
        assertEquals("ID del secondo Shooter non è 1", 1, shooter2.getId());
		}

	@Test
	public void testIdProgressiviPerAltroTipoDinamico() {
		Explorer explorer1 = new Explorer(campo);
        Explorer explorer2 = new Explorer(campo);
        Explorer explorer3 = new Explorer(campo);
        Explorer explorer4 = new Explorer(campo);
        Shooter shooter1 = new Shooter(campo);
        Shooter shooter2 = new Shooter(campo);
        
        assertEquals("ID del primo Explorer non è 0", 0, explorer1.getId());
        assertEquals("ID del secondo Explorer non è 1", 1, explorer2.getId());
        assertEquals("ID del terzo Explorer non è 2", 2, explorer3.getId());
        assertEquals("ID del quarto Explorer non è 3", 3, explorer4.getId());
        
        
        assertEquals("ID del primo Shooter non è 0", 0, shooter1.getId());
        assertEquals("ID del secondo Shooter non è 1", 1, shooter2.getId());
		
	}

}
