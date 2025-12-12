package gen.tipo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import gen.sim.Ambiente;
import gen.tipo.Bianco;

/** 
 * Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 * RIVEDERE {@link #testIdProgressiviPerBianche()}<BR/>
 * COMPLETARE {@link #testIdProgressiviPerGialle()}<BR/>
 * <B>(VEDI DOMANDA 2)</B>
 */
public class AnimaleTest {

	private Ambiente ambiente;
	
	@Before
	public void setUp() throws Exception {
		this.ambiente = new Ambiente();
	}

	@Test
	public void testIdProgressiviPerBianchi() {
		// DA RIVEDERE VEDI DOMANDA 2a
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Bianco(this.ambiente).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Bianco(this.ambiente).getId());
	}

	@Test
	public void testIdProgressiviPerAltroColore() {
		// DA COMPLETARE VEDI DOMANDA 2bcd
		fail("DA COMPLETARE");
	}

}
